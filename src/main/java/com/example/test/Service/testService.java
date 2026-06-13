package com.example.test.Service;

import java.util.List;
import java.util.Map;

import com.example.test.DTO.SegmentDto;

public interface testService {
	
	public void save(List<SegmentDto> segments);
	
	public String analyze();
	
	public Map<String, Object> analyzeResult();
	
	public List<Map<String, Object>> readJsonFile();

}
