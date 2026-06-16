package com.example.test.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.test.DTO.SegmentDto;
import com.example.test.DTO.VideoDto;


@Repository
public class testRepository {
	
	private final List<SegmentDto> measurements = new ArrayList<>();
	
	private final List<VideoDto> videos = new ArrayList<>();
	
	
	public void insertData(List<SegmentDto> segments) {
		
        measurements.addAll(segments);

        System.out.println("현재 저장 개수 : " + measurements.size());
		
	}
	
	public List<SegmentDto> findAll() {
		//DB가 연결되어 있다면 select 구문이 들어감
		return measurements;
	}
	
    public void saveRecording(VideoDto video) {
        videos.add(video);
        System.out.println("저장완료"+videos);
    }
	
    public List<VideoDto> findVideo() {
        return videos;
    }
	
	

}
