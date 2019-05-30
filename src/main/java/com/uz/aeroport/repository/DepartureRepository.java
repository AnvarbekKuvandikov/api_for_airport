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

    @Query(value = "select depart.time , air_lines.image,depart.destination_uzb," +
            "depart.destination_rus,depart.destination_eng,depart.flight,depart.terminal,depart.status,depart.status_time," +
            "depart.boarding_closed,depart.check_in_closed,depart.type"+
            " from depart inner join air_lines on air_lines.id = depart.airline_id  where depart.depart_date = (:date1)",nativeQuery = true)
    List<Object[]> findForDepartTerminal(@Param("date1")LocalDate date1);

    @Query(value = "select depart.time , air_lines.image,depart.destination_uzb," +
            "depart.destination_rus,depart.destination_eng,depart.flight,depart.terminal,depart.status,depart.status_time,depart.boarding_closed,depart.check_in_closed,depart.type" +
            " from depart inner join air_lines on air_lines.id = depart.airline_id  where depart.depart_date =(:date1)" +
            " and depart.terminal=(:terminal)",nativeQuery = true)
    Object[] findForOneDepartTerminal(@Param("date1")LocalDate date1,@Param("terminal") String terminal);
}
