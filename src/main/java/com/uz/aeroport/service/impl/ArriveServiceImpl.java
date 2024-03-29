package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.ArriveDto;
import com.uz.aeroport.dto.ArriveTerminalDto;
import com.uz.aeroport.entity.ArriveEntity;
import com.uz.aeroport.repository.ArriveRepository;
import com.uz.aeroport.service.ArriveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        arriveEntity.setArriveDate(dto.getArriveDate());
        arriveEntity.setDestinationUzb(dto.getDestinationUzb());
        arriveEntity.setDestinationRus(dto.getDestinationRus());
        arriveEntity.setDestinationEng(dto.getDestinationEng());
        arriveEntity.setFlight(dto.getFlight());
        arriveEntity.setStatus(dto.getStatus());
        arriveEntity.setStatusTime(dto.getStatusTime());
        arriveEntity.setAirlineId(dto.getAirlineId());
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
    public List<ArriveDto> getByFilter(LocalDate date1)
    {
        List<ArriveDto> arriveDtos = new ArrayList<>();
        List<ArriveEntity> arriveEntities = arriveRepository.fidByDate(date1);
        arriveEntities.forEach(arriveEntity -> {
            ArriveDto arriveDto = new ArriveDto();
            arriveDto.setId(arriveEntity.getId());
            arriveDto.setFlight(arriveEntity.getFlight());
            arriveDto.setTime(arriveEntity.getTime());
            arriveDto.setDestinationUzb(arriveEntity.getDestinationUzb());
            arriveDto.setDestinationEng(arriveEntity.getDestinationEng());
            arriveDto.setDestinationRus(arriveEntity.getDestinationRus());
            arriveDto.setArriveDate(arriveEntity.getArriveDate());
            arriveDto.setStatus(arriveEntity.getStatus());
            arriveDto.setStatusTime(arriveEntity.getStatusTime());
            arriveDto.setAirlineId(arriveEntity.getAirlineId());
            arriveDtos.add(arriveDto);
        });
        return arriveDtos;
    }
    @Override
    public List<ArriveDto> getAll()
    {
        List<ArriveDto> list = new ArrayList<>();
        List<ArriveEntity> l = arriveRepository.findAll();
        l.forEach(arriveEntity ->
        {
            ArriveDto arriveDto = new ArriveDto();
            arriveDto.setId(arriveEntity.getId());
            arriveDto.setDestinationUzb(arriveEntity.getDestinationUzb());
            arriveDto.setArriveDate(arriveEntity.getArriveDate());
            arriveDto.setDestinationEng(arriveEntity.getDestinationEng());
            arriveDto.setDestinationRus(arriveEntity.getDestinationRus());
            arriveDto.setFlight(arriveEntity.getFlight());
            arriveDto.setTime(arriveEntity.getTime());
            arriveDto.setStatus(arriveEntity.getStatus());
            arriveDto.setStatusTime(arriveEntity.getStatusTime());
            arriveDto.setAirlineId(arriveEntity.getAirlineId());
            list.add(arriveDto);
        });
        return list;
    }

    @Override
    public void changedById(ArriveDto arriveDto)
    {
        Optional<ArriveEntity> optional = arriveRepository.findById(arriveDto.getId());
        if(optional.isPresent()){
            ArriveEntity arriveEntity = optional.get();
            BeanUtils.copyProperties(arriveDto,arriveEntity);
            arriveRepository.save(arriveEntity);
        }
    }

    @Override
    public List<ArriveTerminalDto> getToShow(LocalDate date1)
    {
        List<Object[]> list1 = arriveRepository.getForArriveTerminal(date1);
        List<ArriveTerminalDto> lists = new ArrayList<>();
        list1.forEach(objects ->
        {
            ArriveTerminalDto arriveTerminalDto = new ArriveTerminalDto();
            arriveTerminalDto.setTime((String)objects[0]);
            arriveTerminalDto.setLogo((String)objects[1]);
            arriveTerminalDto.setDestinationUzb((String)objects[2]);
            arriveTerminalDto.setDestinationRus((String)objects[3]);
            arriveTerminalDto.setDestinationEng((String)objects[4]);
            arriveTerminalDto.setFlight((String)objects[5]);
            arriveTerminalDto.setStatus((String)objects[6]);
            arriveTerminalDto.setStatusTime((String)objects[7]);
            lists.add(arriveTerminalDto);
        });
        return lists;
    }


}
