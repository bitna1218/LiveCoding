package com.example.test.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.example.test.AI.AnalyzeAssessment;
import com.example.test.DTO.SegmentDto;
import com.example.test.Repository.testRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class testServiceImpl implements testService{
	
	private final testRepository repo;
	
	CompletableFuture<Map<String, Object>> future;
	
	public testServiceImpl(testRepository repo) {
		this.repo = repo;
	}


	@Override
	public void save(List<SegmentDto> segments) {
		repo.insertData(segments);
	}


	@Override
	public String analyze() {
		
		List<SegmentDto> measurements = repo.findAll();
		
		future =AnalyzeAssessment.analyzeAssessment(measurements);
				
		return "OK";
		
	}
	
	@Override
	public Map<String, Object> analyzeResult() {
		
		
	    if (future == null) {
	        return Map.of(
	            "status", "FAILED"
	        );
	    }
		
	    if (!future.isDone()) {
	        return Map.of(
	            "status", "ANALYZING"
	        );
	    }
	    
	    
	    return Map.of(
	        "status", "COMPLETED",
	        "result", future.join()
	    );
		
	}
	
	
	@Override
	public List<Map<String, Object>> readJsonFile() {
	
		ObjectMapper objectMapper = new ObjectMapper();
	        

		File file = new File( "src/main/resources/sampleData.json");

		try {
				
				Map<String,Object> jsonData =objectMapper.readValue(file,new TypeReference<Map<String,Object>>() {});
				
				List<Map<String, Object>> results = (List<Map<String, Object>>) jsonData.get("results");
				
				return results;
				
			}catch (IOException e) {
		        System.err.println("JSON 파일 읽기 실패 : " + e.getMessage());
		        return Collections.emptyList();
		    }
	       
	}



}
