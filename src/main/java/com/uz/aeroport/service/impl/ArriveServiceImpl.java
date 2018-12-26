package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.ArriveDto;
import com.uz.aeroport.repository.ArriveRepository;
import com.uz.aeroport.service.ArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jack on 26.12.2018.
 */
@Service
public class ArriveServiceImpl implements ArriveService
{
    @Autowired
    private ArriveRepository arriveRepository;

    @Override
    public void create(ArriveDto dto) {

    }
}
