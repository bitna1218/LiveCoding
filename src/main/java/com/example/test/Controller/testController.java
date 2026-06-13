package com.example.test.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.example.test.DTO.SegmentDto;
import com.example.test.Service.testService;


@Controller
public class testController {
	
	private final testService service;
	
	public testController(testService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String test() {
		return "redirect:/scaffold.html";
	}
	
	@GetMapping("/result") 
    public String showResultPage(Model model) {
		
		List<Map<String, Object>> result = service.readJsonFile();
		
		model.addAttribute("result", result);
		
        return "resultPage"; 
    }


	@PostMapping("/segments")
	@ResponseBody
	public ResponseEntity<Map<String, String>> start(@RequestBody List<SegmentDto> segments) {
	    try {
	        service.save(segments);

	        return ResponseEntity.ok(Map.of("message", "데이터 저장에 성공했습니다."));
	        
	    } catch (Exception e) {

	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Map.of("message", "서버 오류 발생: " + e.getMessage()));
	    }
	}
	
	@PostMapping("/segments/end")
	@ResponseBody
	public ResponseEntity<Map<String, String>> end() {
	    try {
	        String result = service.analyze();
	        
	        if ("OK".equals(result)) {
	            return ResponseEntity.ok(Map.of("status", "ANALYZING"));
	        }
	        
	        return ResponseEntity.ok(Map.of("status", "FAILED"));
	        
	    } catch (Exception e) {
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Map.of("status", "FAILED", "message", e.getMessage()));
	    }
	}
	
	@GetMapping("/segments/status")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> status() {
	    try {
	        Map<String, Object> status = service.analyzeResult();
	        
	        return ResponseEntity.ok(status); 
	        
	    } catch (Exception e) {
	        
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Map.of("status", "FAILED", "error", e.getMessage()));
	    }
	}
	
}
