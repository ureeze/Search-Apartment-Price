# 아파트 실거래가 조회
+ 공공데이터포털에서 제공하는 아파트매매 실거래 상세자료 OPEN API를 이용하여 지역/전용면적/기간을 기준으로 아파트 시세를 시각화 하여 직관적인 서비스 제공  

## 주요내용
+ 아파트매매 실거래 상세자료 OPEN API를 이용하여 아파트 실거래가를 그래프, 지도, 리스트로 시각화 하여 표현
+ 그래프의 경우 AmChart.JS 라이브러리를 이용하여 XY그래프형식으로 거래시점에 대한 실거래가 표현
+ GeoCode클래스에서 네이버 geocode API를 이용하여 입력주소에 해당하는 지도상의 X,Y좌표를 알아냄
+ 위의 X,Y좌표를 네이버지도 API를 이용하여 지도상에 클러스터화 하여 거래 빈도수를 표현
+ 공공데이터포털 OPEN API를 XML형식으로 데이터 조회 후 필요한 ITEM값과 X,Y좌표를 JSON형식으로 재가공하여 VIEW로 전달  

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

## 
![그림1](https://user-images.githubusercontent.com/37195463/115117752-142bc880-9fdb-11eb-9af3-a247e60f94ac.png)

## 아파트 거래목록
![apart list2](https://user-images.githubusercontent.com/37195463/134794276-4acf471f-a30d-4853-9bd0-4f4331b891d2.png)

## 실거래가
![xymap2](https://user-images.githubusercontent.com/37195463/134794216-c33f7b43-cb6e-4223-b0a2-8b4d65f7aa14.png)

## 지역별 거래량
> 아파트 거래량을 네이버지도 API를 이용하여 클러스터화 하여 직관적으로 표현

![apart map2](https://user-images.githubusercontent.com/37195463/134794213-dcd248da-eac7-4527-8d6f-43b100d54239.png)
