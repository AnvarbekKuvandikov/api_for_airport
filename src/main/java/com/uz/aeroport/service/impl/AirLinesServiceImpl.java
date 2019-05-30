package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.AirlinesDto;
import com.uz.aeroport.entity.AirLinesEntity;
import com.uz.aeroport.repository.AirLinesRepository;
import com.uz.aeroport.service.AirLinesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jack on 25.01.2019.
 */
@Service
public class AirLinesServiceImpl implements AirLinesService {
    @Autowired
    private AirLinesRepository airLinesRepository;


    @Override
    public void create(AirlinesDto air) {
        AirLinesEntity airLinesEntity1 = new AirLinesEntity();
        airLinesEntity1.setNameAirline(air.getNameAirline());
        airLinesEntity1.setImage(air.getImage());
        airLinesRepository.save(airLinesEntity1);
    }

    @Override
    public AirlinesDto getById(Long id)
    {
        Optional<AirLinesEntity> airLinesEntity = airLinesRepository.findById(id);
        if(airLinesEntity.isPresent())
        {
            AirlinesDto airlinesDto = new AirlinesDto();
            AirLinesEntity airLinesEntity1 = airLinesEntity.get();
            BeanUtils.copyProperties(airLinesEntity1,airlinesDto);
            return airlinesDto;
        }
        return null;
    }

    @Override
    public List<AirlinesDto> getAll()
    {
        List<AirLinesEntity> linesEntities = airLinesRepository.findAll();
        List<AirlinesDto> result = new ArrayList<>();
        linesEntities.forEach(airLinesEntity -> {
            AirlinesDto airlinesDto = new AirlinesDto();
            airlinesDto.setNameAirline(airLinesEntity.getNameAirline());
            airlinesDto.setImage(airLinesEntity.getImage());
            airlinesDto.setId(airLinesEntity.getId());
            result.add(airlinesDto);
        });
        return result;
    }




}
