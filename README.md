# 아파트 실거래가 조회
공공데이터포털에서 제공하는 아파트매매 실거래 상세자료 OPEN API를 이용하여
지역/전용면적/기간을 기준으로 시세파악을 쉽게 할 수 있는 서비스 제공  

![그림1](https://user-images.githubusercontent.com/37195463/115117752-142bc880-9fdb-11eb-9af3-a247e60f94ac.png)
![그림2](https://user-images.githubusercontent.com/37195463/115117749-12620500-9fdb-11eb-9e1e-8bdbff38248c.png)

## 주요내용
• 공공데이터포털 OPEN API를 JSON형식으로 데이터 조회 후 재가공하여 화면전송  
• 네이버지도 API와 네이버 geocode API를 활용하여 해당지역에 어느 정도의 거래가 이루어졌는지 클러스터화 하여 지도에 표현  
• AmChart.JS 라이브러리를 이용하여 XY그래프형식으로 거래시점에 대한 실거래가 표현  

## 사용언어
+ JAVA 8
+ HTML/CSS
+ JavaScript

## 사용 라이브러리 및 프레임워크
+ Spring Boot 2.4.1
+ AmChart.JS
+ Spring Data JPA
+ MySQL
+ Thymeleaf
+ JSON.simple
