package com.uz.aeroport.repository;

import com.uz.aeroport.entity.ArriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Jack on 26.12.2018.
 */
public interface ArriveRepository extends JpaRepository<ArriveEntity,Long>
{

    @Query(value = "select * from arrive where arrive_date = (:date1)",nativeQuery = true)
    List<ArriveEntity> fidByDate(@Param("date1") LocalDate date1);
}
