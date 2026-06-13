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

## 기능구현 설명
1. 실시간 데이터 지속적으로 전송이 무리가 있다 판단하여 1초에 한번씩 묶어서 데이터 전송
2. AI 데이터 전송후 분석은 백그라운드에서 진행을 된다는 가정을 하고 1초에 한번씩 상태를 체크하여 분석이 끝나면 알려줌
3. AI 에게 분석결과를 받아왔다치고 주어진 JSON 파일을 읽어 결과페이지에 보여줌 
     

---

## 프로젝트 구조 (Project Structure)
```text
├── src/main/java
│   ├── AI/                   # mock AI
│   ├── Controller/           # Entry Point 
│   ├── DTO/                  # 데이터 담는 객체
│   ├── Repository/           # DB에서 저장하거나 불러오는 기능 구현 
│   └── Services/             # 비지니스 로직 구현
├── src/main/resources        
│   └── templates/
│   │  └── resultPage.html    # 분석 결과 화면
│   └── static/
│   │  └── scaffold.html      # 실시간운동 데이터 수집화면
