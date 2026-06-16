package com.example.test.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.test.DTO.SegmentDto;
import com.example.test.DTO.VideoDto;

public interface testService {
	
	public void save(List<SegmentDto> segments);
	
	public String analyze();
	
	public Map<String, Object> analyzeResult();
	
	public List<Map<String, Object>> readJsonFile();
	
	public void uploadRecording (MultipartFile file) throws IOException;
	
	public List<VideoDto> readVideo();
	

}
