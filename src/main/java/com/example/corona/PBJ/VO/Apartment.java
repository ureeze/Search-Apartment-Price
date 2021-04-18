package com.example.corona.PBJ.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

    @Id
    private Long id; // id


    // 거래금액(문자) xml[0]
    private String samount;

    // 거래금액(숫자) xml[0]
    private int numamount;

    // 건축년도 xml[1]
    private int originyear;

    // 년(거래년도) xml[2]
    private int changeyear;

    // 도로명 xml[3]
    private String roadname;

    // 법정동 xml[10]
    private String dong;

    // 법정동 지번[11]
    private String dongnum;

    // 법정동시군구코드 xml[13]
    private String sicode;

    // 법정동읍면동코드 xml[14]
    private String dongcode;

    // 아파트명 xml[16]
    private String apartname;

    // 월 xml[17]
    private int month;

    // 일 xml[18]
    private int day;

    // 전용면적 xml[20]
    private Double area;

    // 지번 xml[21]
    private String areanumber;

    // 층 xml[23]
    private String floor;

    private Double x;

    private Double y;

    private LocalDate date;
}