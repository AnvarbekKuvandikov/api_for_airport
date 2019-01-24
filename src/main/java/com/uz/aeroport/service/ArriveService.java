package com.uz.aeroport.service;

import com.uz.aeroport.dto.ArriveDto;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Jack on 26.12.2018.
 */
public interface ArriveService
{

    void create(ArriveDto dto);

    ArriveDto findOne(Long id);

    List<ArriveDto> getByFilter(LocalDate date1);

    List<ArriveDto> getAll();

    void changedById(ArriveDto arriveDto);
}
