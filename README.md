# LiveCoding Backend Server

사용자로부터 실시간 운동 데이터를 수집하고 가공하여, 컴퓨터 비전 및 머신러닝 AI 모델로 중계·전달하는 백엔드 시스템 입니다.

## 프로젝트 개요 (Overview)
본 프로젝트는 실시간 운동 자세 피드백 시스템의 **데이터 파이프라인 가교(Bridge)** 역할을 담당하는 백엔드 애플리케이션입니다. 
프론트엔드(웹캠 프레임 또는 센서 데이터)에서 전송된 운동 메타데이터 및 포즈 좌표를 안정적으로 수신하고 검증한 뒤, 이를 AI 분석 엔진에 효율적으로 포워딩하여 분석 결과를 연동할 수 있도록 설계되었습니다.

## Data Flow
1. **save**

측정시작 -> controller -> serviceImpl -> repository -> 임시 메모리

2. **analyze**

측정 종료 -> 임시 메모리 -> repository -> serviceImpl -> AI -> serviceImpl -> controller -> 결과화면

---

## 프로젝트 구조 (Project Structure)
```text
├── src/main/java
│   ├── AI/                   # mock AI
│   ├── Controller/           # Entry Point 지
│   ├── DTO/                  # 데이터 담는 객체
│   ├── Repository/           # DB에서 저장하거나 불러오는 기능 구현 
│   └── Services/             # 비지니스 로직 구현
├── src/main/resources        
│   └── templates/
│   │  └── resultPage.html    # 분석 결과 화면
│   └── static/
│   │  └── scaffold.html      # 실시간운동 데이터 수집화면
