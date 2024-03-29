package com.uz.aeroport.service;

import com.uz.aeroport.dto.DepartTerminalDto;
import com.uz.aeroport.dto.DepartureDto;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Jack on 26.12.2018.
 */
public interface DepartureService
{
    void create(DepartureDto departureDto);

    DepartureDto findOne(Long id);

    List<DepartureDto> getAll();

    List<DepartureDto> getNew(LocalDate date);

    void changeById(DepartureDto departureDto);

    List<DepartTerminalDto> getDepartureTerminalData(LocalDate date1);

}
