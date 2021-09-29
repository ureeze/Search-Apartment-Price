# 아파트 실거래가 조회
+ 공공데이터포털에서 제공하는 아파트매매 실거래 상세자료 OPEN API를 이용하여 지역/전용면적/기간을 기준으로 아파트 시세를 시각화 하여 직관적인 서비스 제공  

![구조2](https://user-images.githubusercontent.com/37195463/135212232-8fbe789e-5f89-4e55-ba93-b268b7c648be.png)


## 1. 전체화면
![20210119_003308](https://user-images.githubusercontent.com/37195463/135212444-09e78221-2d85-406b-9fdc-a1c2b556f179.png)

## 주요 내용
+ 아파트매매 실거래 상세자료 OPEN API를 이용하여 아파트 실거래가를 그래프, 지도, 리스트로 시각화 하여 표현
+ 그래프의 경우 AmChart.JS 라이브러리를 이용하여 XY그래프형식으로 거래시점에 대한 실거래가를 표현
+ GeoCode클래스에서 네이버 geocode API를 이용하여 입력주소에 해당하는 지도상의 X,Y좌표를 알아냄
+ 위의 X,Y좌표를 네이버지도 API를 이용하여 지도상에 클러스터화 하여 거래 빈도수를 표현
+ 공공데이터포털 OPEN API를 XML형식으로 데이터 조회 후 필요한 ITEM값과 X,Y좌표를 VIEW로 반환

## 사용 언어
> JAVA 8  
> HTML/CSS  
> JavaScript  

## 데이터베이스
> MySQL  

## 사용 라이브러리 및 프레임워크
> Spring Boot 2.4.1  
> AmChart.JS  
> Spring Data JPA  
> Thymeleaf  
> JSON.simple  

## 2. 공공데이터 API XML데이터
![apart api](https://user-images.githubusercontent.com/37195463/135212292-55f97693-7a67-4dd9-8c53-f718cf400b06.png)

## 3. 아파트 거래목록
![apart list2](https://user-images.githubusercontent.com/37195463/135212437-cd2d89a0-ca86-4950-97af-26206f2a6bda.png)

## 4. 실거래가
![xymap](https://user-images.githubusercontent.com/37195463/135212434-66c510ad-b438-43f2-84e7-f0c11ced859d.png)

## 5. 지역별 거래량
> 아파트 거래량을 네이버지도 API를 이용하여 클러스터화 하여 직관적으로 표현

![apart map2](https://user-images.githubusercontent.com/37195463/135212427-b64e3a61-c5cf-4a1c-9deb-ab6e3785c328.png)
