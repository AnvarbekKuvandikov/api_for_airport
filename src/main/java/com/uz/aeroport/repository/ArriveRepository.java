package com.uz.aeroport.repository;

import com.uz.aeroport.dto.ArriveTerminalDto;
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

    @Query(value = "select arrive.time,air_lines.image, arrive.destination_uzb" +
            ",arrive.destination_rus, arrive.destination_eng, arrive.flight, arrive.status,arrive.status_time" +
            " from arrive inner join air_lines on air_lines.id = arrive.airline_id  where arrive.arrive_date = (:date1)",nativeQuery = true)
    List<Object[]> getForArriveTerminal(@Param("date1") LocalDate date1);


}
