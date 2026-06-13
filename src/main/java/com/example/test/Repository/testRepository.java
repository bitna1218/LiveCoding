package com.example.test.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.test.DTO.SegmentDto;


@Repository
public class testRepository {
	
	private final List<SegmentDto> measurements = new ArrayList<>();
	//private final Map<String, Object> result = new ArrayList<>();
	
	
	public void insertData(List<SegmentDto> segments) {
		
        measurements.addAll(segments);

        System.out.println("현재 저장 개수 : " + measurements.size());
		
	}
	
	public List<SegmentDto> findAll() {
		//DB가 연결되어 있다면 select 구문이 들어감
		return measurements;
	}
	
	

}
