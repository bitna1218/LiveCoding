package com.example.test.DTO;

import java.util.List;

public class SegmentDto {
	
    private long timestamp;

    private List<LandmarkDto> poseLandmarks;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public List<LandmarkDto> getPoseLandmarks() {
		return poseLandmarks;
	}

	public void setPoseLandmarks(List<LandmarkDto> poseLandmarks) {
		this.poseLandmarks = poseLandmarks;
	}
    
    

}
