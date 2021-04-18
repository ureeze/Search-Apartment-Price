package com.example.corona.PBJ.repository;

import com.example.corona.PBJ.VO.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BoardRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findBySicodeAndDongcode(String sicode, String dongcode);

    List<Apartment> findByApartnameAndArea(String apartname, String area);

    @Query("SELECT a FROM Apartment a WHERE a.dong = ?1 and a.date >= ?2 and a.area between ?3 and ?4")
    List<Apartment> findByDongAndDateAndArea(String dong, LocalDate date, Double start, Double end);

    @Query("SELECT a FROM Apartment a WHERE a.area between ?1 and ?2")
    List<Apartment> findByArea(Double start, Double end);
}
