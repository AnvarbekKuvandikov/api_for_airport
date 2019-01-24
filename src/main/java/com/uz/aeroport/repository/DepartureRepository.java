package com.uz.aeroport.repository;

import com.uz.aeroport.entity.DepartureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Jack on 26.12.2018.
 */
public interface DepartureRepository extends JpaRepository<DepartureEntity,Long> {

    @Query(value = "select * from depart where depart_date = (:date)",nativeQuery = true)
    List<DepartureEntity> findByDate(@Param("date") LocalDate date);
}
