# :pushpin: The Ai Fitness
>운동자세 영상분석을 통한 한세 기구별 자세교정 서비스


## 1. 제작 기간 & 참여 인원
- 2021.10.01 - 2021.11.02
- 팀프로젝트 : 4명


## 2. 사용 기술
#### `Back-end`    
  - Java 8
  - Spring Boot 3.1
  - Maven
  - JSP
  - HikariCP 2.74
  - MySQL 5.1
  - Flask
  - Ajax
#### `Front-end`
  - JavaScript
  - JSTL
#### `자세분석`
  - MediaPipe
</br>

## 3. ERD 설계
![캡처](https://user-images.githubusercontent.com/48014869/180605099-0a1a70d3-22c3-4f02-877e-e3ac675d6f67.PNG)

## 4. 핵심 기능
이 서비스의 핵심 기능은 실시간으로 나의 자세를 피드백을 받을 수 있습니다.
사용자는 자신이 원하는 기구를 선택한 뒤 운동 셋트 수 와 갯수를 입력하면 실시간 피드백과
동시에 갯수를 채운다면 자동으로 운동이 종료되는 시스템을 가지고 있습니다.
<br>
#### 서비스 목표 기능
1. 실시간 자세 교정을 통한 피드백
2. 운동 기록 및 정확한 운동시간 측정을 통한 칼로리 기록
3. 관리자 페이지를 제작함에 있어 관리자도 회원들을 쉽게 관리 할 수 있다.


<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">

### 4.1. 전체 흐름
![image](https://user-images.githubusercontent.com/48014869/180639820-5f51a05f-a93b-4552-8117-b409c26a21ca.png)

### 4.2. 유스케이스 다이어그램
![유스케이스](https://user-images.githubusercontent.com/48014869/180638498-8854baa0-525b-44e0-ba1d-5f0724653d5b.PNG)


### 4.3. Controller

![](https://zuminternet.github.io/images/portal/post/2019-04-22-ZUM-Pilot-integer/flow_controller.png)

- **요청 처리** :pushpin: 
  - Controller에서는 요청을 화면단에서 넘어온 요청을 받고, 동시에 비지니스 로직을 수행합니다.

- **결과 응답** :pushpin:
  - 결과에 대한 응답은 Mapper 를 mapping 된 네이밍을 따라 XML 에서 값을 가져옵니다.

</div>
</details>

## 4. 나의 역할
전체적인 Backend controller 설계 및 sql ajax 를 구현하는 역할이 주로 맡았습니다.

#### 기여한 일 
**google calendar를 통한 UI/UX제작 및 backend 기능 구현(출처: google)**:pushpin:
  - 예시 : 기존에 제공된 api구조를 파악
  - 내용 : 파악된 api구조를 저희의 UI/UX에 맞게 제작 및 backend기능 구현

**backend기능 구현**:pushpin:
  - 예시 : 메인 페이지 / 피드백 페이지 등
  - 내용 : 해당 페이지 HTML구조를 파악한 뒤 AJAX / JSTL / JAVASCRIPT를 통한 데이터를 넘겨주고 받기 구현

**Flask를 통해 Python 연동**:pushpin:
  - 내용 : webcam을 통한 실시간 영상 분석

