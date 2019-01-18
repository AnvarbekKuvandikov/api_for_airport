package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.ArriveDto;
import com.uz.aeroport.entity.ArriveEntity;
import com.uz.aeroport.repository.ArriveRepository;
import com.uz.aeroport.service.ArriveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jack on 26.12.2018.
 */
@Service
public class ArriveServiceImpl implements ArriveService
{
    @Autowired
    private ArriveRepository arriveRepository;

    @Override
    public void create(ArriveDto dto)
    {
        ArriveEntity arriveEntity = new ArriveEntity();
        arriveEntity.setTime(dto.getTime());
        arriveEntity.setDepartDate(dto.getDepartDate());
        arriveEntity.setDestinationUzb(dto.getDestinationUzb());
        arriveEntity.setDestinationRus(dto.getDestinationRus());
        arriveEntity.setDestinationEng(dto.getDestinationEng());
        arriveEntity.setFlight(dto.getFlight());
        arriveEntity.setStatus(dto.getStatus());
        arriveEntity.setStatusTime(dto.getStatusTime());
        arriveRepository.save(arriveEntity);
    }

    @Override
    public ArriveDto findOne(Long id)
    {
        Optional<ArriveEntity> arriveEntity = arriveRepository.findById(id);
        ArriveEntity arriveEntity1 = arriveEntity.get();
        ArriveDto arriveDto = new ArriveDto();
        BeanUtils.copyProperties(arriveEntity1,arriveDto);
        return arriveDto;
    }

    @Override
    public List<ArriveDto> getByFilter(Date date1)
    {
        return null;
    }
}
