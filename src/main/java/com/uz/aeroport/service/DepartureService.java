package com.uz.aeroport.service;

import com.uz.aeroport.dto.DepartureDto;

/**
 * Created by Jack on 26.12.2018.
 */
public interface DepartureService
{
    void create(DepartureDto departureDto);

    DepartureDto findOne(Long id);
}
