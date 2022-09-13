## :pushpin: The Ai Fitness
😢**Problem: 저희 서비스는 잘못된 웨이트 트레이닝 습관으로 인한 파생된 프로그램입니다.**

😃**Solution: 실시간으로 운동에 대한 자세분석과 분석을 통해 AI는 기초적인 운동피드백을 드립니다.**

## 1. 시연 영상
#### 회원 가입 및 메인 페이지
![ezgif com-gif-maker (6)](https://user-images.githubusercontent.com/48014869/189920512-1dc63640-8e63-4fe9-a856-37f7cc1e1284.gif)


<details>
<summary>calendar 및 운동 자세 분석</summary>
<div markdown="1">       

![ezgif com-gif-maker (7)](https://user-images.githubusercontent.com/48014869/189920523-3dce9d89-49e8-43f6-845f-ded51754b6f4.gif)

</div>
</details>

<details>
<summary>운동 기록 및 자세 확인</summary>
<div markdown="1">       

![ezgif com-gif-maker](https://user-images.githubusercontent.com/48014869/189921446-e6ffc060-d2c8-49f4-8da1-ca5cf50b20fc.gif)


</div>
</details>




## 2. 핵심 기능
이 서비스의 핵심 기능은 실시간으로 나의 자세를 피드백을 받을 수 있습니다.
사용자는 자신이 원하는 기구를 선택한 뒤 운동 셋트 수 와 갯수를 입력하면 실시간 피드백과
동시에 갯수를 채운다면 자동으로 운동이 종료되는 시스템을 가지고 있습니다.
<br>
#### 서비스 목표 기능
1. 실시간 자세 교정을 통한 피드백
2. 운동 기록 및 정확한 운동시간 측정을 통한 칼로리 기록
3. 관리자 페이지를 제작함에 있어 관리자도 회원들을 쉽게 관리 할 수 있다.


## 3. 나의 역할
전체적인 Backend controller 설계 및 sql ajax 를 구현하는 역할이 주로 맡았습니다.

#### 기여한 일 
**google calendar를 통한 UI/UX제작 및 backend 기능 구현(출처: google)**:pushpin:
  - 예시 : 기존에 제공된 api구조를 파악
  - 내용 : 파악된 api구조를 저희의 UI/UX에 맞게 제작 및 backend기능 구현
<details>
  <summary><b>세부적 구조</b></summary>
  <div markdown="1">

  ### Calendar
  ![image](https://user-images.githubusercontent.com/48014869/189877959-9f91e573-efcc-47ed-ac9d-752c8c84db72.png)

  - **truble shooting** :pushpin: 
    - 기존에 CalendarApi를 통해 open code를 사용한 Html로 값을 나타낼수 없는 문제 발생
      [문제되는 부분](https://developers.google.com/calendar/api/v3/reference/events)
    - **해결** : JSP는 java 언어이고 해당 페이지 처리의 순서를 이해하고 [해당 작업](https://github.com/dkwktm45/2th-project/blob/171718d55cc8c9b36e421a1827676a04f4b9b886/src/main/webapp/WEB-INF/views/test.jsp#L544-L560)을 수행했습니다.

  - **성과** :pushpin:
      - GoogleCalendar를 사용해 함으로써 open souerce를 친숙해질 수 있었습니다.

  </div>
</details>
<br>

**backend기능 구현**:pushpin:
  - 예시 : 메인 페이지 / 피드백 페이지 등
  - 내용 : 각 페이지 url 에 대한 모든 api를 설계를 맡았습니다.
  <details>
  <summary><b>세부적 구조</b></summary>
  <div markdown="1">

  ### Controller
  ![image](https://user-images.githubusercontent.com/48014869/180640151-e47dca23-eb4b-4857-bcea-05682e836c68.png)

  - **요청 처리** :pushpin: 
    - [Controller](https://github.com/dkwktm45/2th-project/blob/171718d55cc8c9b36e421a1827676a04f4b9b886/src/main/java/com/test/web/Restmember.java#L37-L194)에서는 요청을 화면단에서 넘어온 요청을 받고, 동시에 비지니스 로직을 수행합니다.

  - **결과 응답** :pushpin:
      - 결과에 대한 응답은 [Mapper](https://github.com/dkwktm45/2th-project/blob/171718d55cc8c9b36e421a1827676a04f4b9b886/src/main/java/com/test/mapper/mainMapper.java#L12-L57) 를 mapping 된 네이밍을 따라 [XML](https://github.com/dkwktm45/2th-project/blob/171718d55cc8c9b36e421a1827676a04f4b9b886/src/main/java/com/test/mapper/mainMapper.xml#L5-L125) 에서 값을 가져옵니다.

  - **성과** :pushpin:
      - 많은 요청과 처리를 하면서 Http 표준 규약에 대해 직면하면서 requests과 response에 대한 기본적인 처리를 배워갈 수 있었습니다.

  </div>
  </details>
<br>

**Flask를 통해 Python 연동**:pushpin:
  - 내용 : webcam을 통한 실시간 영상 분석

</br>

## 4. 제작 기간 & 참여 인원
- 2021.10.01 - 2021.11.02
- 팀프로젝트 : 4명


## 5. 사용 기술
#### `Back-end`    
  - Java 8 , Spring Boot 3.1 , Maven , JSP , HikariCP 2.74 , MySQL 5.1 ,Flask , Ajax
#### `Front-end`
  - JavaScript , JSTL
#### `자세분석`
  - MediaPipe
</br>

## 6 .기획 및 설계
#### 6.1 서비스 흐름도
![image](https://user-images.githubusercontent.com/48014869/189869632-23b14def-7bb8-40d2-8df2-20afb3b84e54.png)


#### 6.2 유스케이스 다이어그램
![유스케이스](https://user-images.githubusercontent.com/48014869/180638498-8854baa0-525b-44e0-ba1d-5f0724653d5b.PNG)

#### 6.3 ERD 설계
![image](https://user-images.githubusercontent.com/48014869/180640245-3bbfe500-8dfe-4390-ba38-ec3c27d408c6.png)
