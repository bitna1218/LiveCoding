package com.example.test.DTO;

public class VideoDto {
	
    private String fileName;

    private byte[] data;

    public VideoDto(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

}
