package com.example.test.AI;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import com.example.test.DTO.SegmentDto;

public class AnalyzeAssessment {

    private static final Random RANDOM = new Random();

    /**
     * mock 분석 함수 — 실제 AI 대신 10초 걸리는 척하는 함수.
     * 비동기로 쓰고 싶으면 CompletableFuture 그대로,
     * 동기로 쓰고 싶으면 .join() 으로 받으면 됩니다.
     */
    
//    public static CompletableFuture<Map<String, Object>> analyzeAssessment(List<Map<String, Object>> measurements) {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(10000); // 10초 지연 (PC-2)
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            return Map.of(
//                "score", RANDOM.nextInt(101),          // 0~100
//                "analyzedAt", Instant.now().toString()
//            );
//        });
//    }
    
    
    public static CompletableFuture<Map<String, Object>> analyzeAssessment(List<SegmentDto> measurements) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000); // 10초 지연 (PC-2)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return Map.of(
                "score", RANDOM.nextInt(101),          // 0~100
                "analyzedAt", Instant.now().toString()
            );
        });
    }
    

    // (참고) 동기 버전이 편하면 이렇게 써도 됨
    public static Map<String, Object> analyzeAssessmentSync(List<Map<String, Object>> measurements) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return Map.of("score", RANDOM.nextInt(101), "analyzedAt", Instant.now().toString());
    }
  

}
