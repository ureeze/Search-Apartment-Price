package com.example.corona.PBJ.service;

import com.example.corona.PBJ.Geocode;
import com.example.corona.PBJ.VO.Apartment;
import com.example.corona.PBJ.VO.Option;
import com.example.corona.PBJ.repository.BoardRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<Apartment> dbRefreshService() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        LocalDate currentDate = LocalDate.now();

        String pageNo = "1";      // 페이지번호
        String numOfRows = "50";  // 한 페이지 결과 수
        String LAWD_CD = "11710"; // 지역코드
        String DEAL_YMD = currentDate.format(formatter);   // 현재날자
        String serviceKey = "XJCl9AL7e5Gu8VNG5MmBet5eJfYCWDDtj6XpcpwnKs8pi46PVanyuviU%2FmOzGTTonak8%2BVCWlI4F4hpm80ITww%3D%3D";

        int term_month = 60;
        String[] period = new String[term_month];

        LocalDate localdate = currentDate;
        period[0] = localdate.format(formatter);
        for (int i = 1; i < term_month; i++) {
            localdate = localdate.minusMonths(1);
            String date1 = localdate.format(formatter);
            period[i] = date1;
            System.out.println(date1);
        }


        List<Apartment> apartlist = new ArrayList<>();
        Long id = 0L;
        for (int k = 0; k < period.length; k++) {


            String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?" +
                    "serviceKey=" + serviceKey + "&pageNo=" + pageNo + "&numOfRows=" + numOfRows + "&LAWD_CD=" + LAWD_CD + "&DEAL_YMD=" + period[k];

            try {
                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();


                Document document = dBuilder.parse(url);
                Element root = document.getDocumentElement();

                // root의 속성
                System.out.println("class name: " + root.getNodeName());
                NodeList nList = document.getElementsByTagName("item");
                System.out.println("파싱할 리스트 수 : " + nList.getLength());

                NodeList totalcountList = document.getElementsByTagName("body");
                String totalcount = totalcountList.item(0).getLastChild().getTextContent();


                for (int i = 0; i < nList.getLength(); ++i) {

                    // <item> 태그의 하위 노드들을 가져온다. ( 여기서 노드는 태그를 의미한다. )
                    NodeList childNodes = nList.item(i).getChildNodes();
                    System.out.println("1개 노드의 데이터 수 : " + childNodes.getLength());
                    if (childNodes.getLength() != 24) {
                        continue;
                    }
                    String s1 = childNodes.item(0).getTextContent().replace(" ", "");
                    String s2 = s1.replace(",", "");
                    int numamount = Integer.parseInt(s2);                                               // 거래금액(문자) idx[0]

                    StringBuilder s3 = new StringBuilder(s1);
                    s3.insert(s3.length() - 5, "억 ");  // 거래금액(숫자) idx[0]

                    String samount = "00";
                    if (s3.charAt(s3.length() - 5) == '0') {
                        samount = s3.toString().replace("0,", "");

                    } else {
                        samount = s3.toString();
                    }

                    int originyear;
                    int changeyear;
                    String roadname;
                    String dong;
                    String dongnum;
                    String sicode;
                    String dongcode;
                    String apartname;
                    int month;
                    int day;
                    Double area;
                    String areanumber;
                    String floor;
                    LocalDate date;

                    Node node;


                    node = childNodes.item(1);
                    if (node.getNodeName().equals("건축년도")) {
                        originyear = Integer.parseInt(node.getTextContent());    // 건축년도 idx[1]
                    } else {
                        originyear = 0;
                    }

                    node = childNodes.item(2);
                    if (node.getNodeName().equals("년")) {
                        changeyear = Integer.parseInt(node.getTextContent());     // 년(거래년도) idx[2]
                    } else {
                        changeyear = 0;
                    }

                    node = childNodes.item(3);
                    if (node.getNodeName().equals("도로명")) {
                        roadname = node.getTextContent() + " " + childNodes.item(4).getTextContent().substring(2);
                        ;     // 도로명 idx[3]+idx[4]
                    } else {
                        roadname = null;
                    }

                    node = childNodes.item(10);
                    if (node.getNodeName().equals("법정동")) {
                        dong = node.getTextContent().trim();     // 법정동 idx[10]
                    } else {
                        dong = null;
                    }

                    node = childNodes.item(11);
                    if (node.getNodeName().equals("법정동본번코드")) {
                        dongnum = node.getTextContent();     // 법정동지번 idx[11]
                    } else {
                        dongnum = null;
                    }

                    node = childNodes.item(13);
                    if (node.getNodeName().equals("법정동시군구코드")) {
                        sicode = node.getTextContent();     // 법정동시군구코드 idx[13]
                    } else {
                        sicode = null;
                    }

                    node = childNodes.item(14);
                    if (node.getNodeName().equals("법정동읍면동코드")) {
                        dongcode = node.getTextContent();     // 법정동읍면동코드 idx[14]
                    } else {
                        dongcode = null;
                    }

                    node = childNodes.item(16);
                    if (node.getNodeName().equals("아파트")) {
                        apartname = node.getTextContent();     // 아파트명 idx[16]
                    } else {
                        apartname = null;
                    }

                    node = childNodes.item(17);
                    if (node.getNodeName().equals("월")) {
                        month = Integer.parseInt(node.getTextContent());     // 월 idx[17]
                    } else {
                        month = 0;
                    }

                    node = childNodes.item(18);
                    if (node.getNodeName().equals("일")) {
                        day = Integer.parseInt(node.getTextContent());       // 일 idx[18]
                    } else {
                        day = 0;
                    }

                    node = childNodes.item(20);
                    if (node.getNodeName().equals("전용면적")) {
                        area = Double.parseDouble(childNodes.item(20).getTextContent());      // 전용면적 idx[20]
                    } else {
                        area = null;
                    }

                    node = childNodes.item(21);
                    if (node.getNodeName().equals("지번")) {
                        areanumber = childNodes.item(21).getTextContent();      // 지번 idx[21]
                    } else {
                        areanumber = null;
                    }

                    node = childNodes.item(23);
                    if (node.getNodeName().equals("층")) {
                        floor = childNodes.item(23).getTextContent();      // 층 idx[23]
                    } else {
                        floor = null;
                    }

                    date = LocalDate.of(changeyear, month, day);

                    Geocode geocode = new Geocode();
                    StringBuilder sb = new StringBuilder();
                    Double[] xy = geocode.getResult(sb.append(dong).append(" ").append(dongnum).toString());

                    Apartment apartment;
                    apartment = new Apartment(id, samount, numamount, originyear, changeyear, roadname, dong, dongnum, sicode, dongcode, apartname, month, day, area, areanumber, floor, xy[0], xy[1], date);


                    System.out.println(apartment.toString());
                    id++;
                    apartlist.add(apartment);
                    boardRepository.save(apartment);
                    System.out.println("--------");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("DB 저장 데이터 수: " + apartlist.size());
        return apartlist;
    }


    public List<Apartment> dbLoadService() {
        List<Apartment> apartlist = boardRepository.findByArea(70.0, 90.0);
        System.out.println("DB 로드 데이터 수: " + apartlist.size());
        return apartlist;
    }

    public List<Apartment> dbInitService() {
        List<Apartment> apartlist = boardRepository.findBySicodeAndDongcode("11710", "10100");
        System.out.println("DB 로드 데이터 수: " + apartlist.size());
        return apartlist;
    }

    public List<Apartment> optionService(Option option) {
        LocalDate localdate = LocalDate.now();

        int year =  localdate.minusYears(option.getYear()).getYear();
        int month = localdate.getMonthValue();
        int day = localdate.getDayOfMonth();

        LocalDate date = LocalDate.of(year, month, day);

        String dong = option.getDong();
        String[] arr = option.getArea().split(",");
        Double[] drr = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            drr[i] = Double.parseDouble(arr[i]);
        }
        System.out.println(date);
        List<Apartment> apartlist = boardRepository.findByDongAndDateAndArea(dong, date, drr[0], drr[1]);

        System.out.println("DB 로드 데이터 수: " + apartlist.size());
        return apartlist;
    }

}
