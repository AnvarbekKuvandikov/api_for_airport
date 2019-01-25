package com.uz.aeroport.service;

import com.uz.aeroport.dto.AirlinesDto;

/**
 * Created by Jack on 25.01.2019.
 */
public interface AirLinesService {
    void create(AirlinesDto airLinesEntity);

    AirlinesDto getById(Long id);
}
