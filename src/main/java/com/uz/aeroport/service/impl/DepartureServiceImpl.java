package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.DepartTerminalDto;
import com.uz.aeroport.dto.DepartureDto;
import com.uz.aeroport.entity.DepartureEntity;
import com.uz.aeroport.repository.DepartureRepository;
import com.uz.aeroport.service.DepartureService;
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
public class DepartureServiceImpl implements DepartureService
{
    @Autowired
    private DepartureRepository departureRepository;

    @Override
    public void create(DepartureDto departureDto)
    {
        DepartureEntity departureEntity = new DepartureEntity();
        departureEntity.setDepartDate(departureDto.getDepartDate());
        departureEntity.setDestinationUzb(departureDto.getDestinationUzb());
        departureEntity.setDestinationRus(departureDto.getDestinationRus());
        departureEntity.setDestinationEng(departureDto.getDestinationEng());
        departureEntity.setFlight(departureDto.getFlight());
        departureEntity.setStatus(departureDto.getStatus());
        departureEntity.setTerminal(departureDto.getTerminal());
        departureEntity.setTime(departureDto.getTime());
        departureEntity.setStatusTime(departureDto.getStatusTime());
        departureEntity.setAirlineId(departureDto.getAirlineId());
        departureRepository.save(departureEntity);
    }
    @Override
    public DepartureDto findOne(Long id)
    {
        Optional<DepartureEntity> departureEntity = departureRepository.findById(id);
        DepartureDto departureDto = new DepartureDto();
        DepartureEntity departureEntity1 = departureEntity.get();
        BeanUtils.copyProperties(departureEntity1,departureDto);
        return departureDto;
    }

    @Override
    public List<DepartureDto> getAll()
    {
        List<DepartureEntity> list = departureRepository.findAll();
        List<DepartureDto> list1 = new ArrayList<>();
        list.forEach(departureEntity -> {
            DepartureDto departureDto = new DepartureDto();
            departureDto.setId(departureEntity.getId());
            departureDto.setTime(departureEntity.getTime());
            departureDto.setTerminal(departureEntity.getTerminal());
            departureDto.setStatus(departureEntity.getStatus());
            departureDto.setDestinationUzb(departureEntity.getDestinationUzb());
            departureDto.setDestinationRus(departureEntity.getDestinationRus());
            departureDto.setDestinationEng(departureEntity.getDestinationEng());
            departureDto.setDepartDate(departureEntity.getDepartDate());
            departureDto.setFlight(departureEntity.getFlight());
            departureDto.setStatusTime(departureEntity.getStatusTime());
            departureDto.setAirlineId(departureEntity.getAirlineId());
            departureDto.setType(departureEntity.getType());
            departureDto.setCheckInClosed(departureEntity.getCheckInClosed());
            departureDto.setBoardingClosed(departureEntity.getBoardingClosed());
            list1.add(departureDto);
        });
        return list1;
    }

    @Override
    public List<DepartureDto> getNew(LocalDate date)
    {
        List<DepartureEntity> departureEntity1 = departureRepository.findByDate(date);
        List<DepartureDto> departureDtos = new ArrayList<>();
        departureEntity1.forEach(dp ->
        {
            DepartureDto departureDto = new DepartureDto();
            departureDto.setId(dp.getId());
            departureDto.setDestinationEng(dp.getDestinationEng());
            departureDto.setDestinationRus(dp.getDestinationRus());
            departureDto.setDestinationUzb(dp.getDestinationUzb());
            departureDto.setDepartDate(dp.getDepartDate());
            departureDto.setStatusTime(dp.getStatusTime());
            departureDto.setStatus(dp.getStatus());
            departureDto.setFlight(dp.getFlight());
            departureDto.setTerminal(dp.getTerminal());
            departureDto.setTime(dp.getTime());
            departureDto.setAirlineId(dp.getAirlineId());
            departureDto.setType(dp.getType());
            departureDto.setCheckInClosed(dp.getCheckInClosed());
            departureDto.setBoardingClosed(dp.getBoardingClosed());
            departureDtos.add(departureDto);
        });
        return departureDtos;
    }

    @Override
    public void changeById(DepartureDto departureDto)
    {
        Optional<DepartureEntity> departureEntity = departureRepository.findById(departureDto.getId());
        if(departureEntity.isPresent())
        {
            DepartureEntity departureEntity1 = departureEntity.get();
            BeanUtils.copyProperties(departureDto,departureEntity1);
            departureRepository.save(departureEntity1);
        }
    }

    @Override
    public List<DepartTerminalDto> getDepartureTerminalData(LocalDate date1)
    {
        List<Object[]> get = departureRepository.findForDepartTerminal(date1);
        List<DepartTerminalDto> list = new ArrayList<>();
        get.forEach(objects ->
        {
            DepartTerminalDto departTerminalDto = new DepartTerminalDto();
            departTerminalDto.setTime((String)objects[0]);
            departTerminalDto.setLogo((String)objects[1]);
            departTerminalDto.setDestinationUzb((String)objects[2]);
            departTerminalDto.setDestinationRus((String)objects[3]);
            departTerminalDto.setDestinationEng((String)objects[4]);
            departTerminalDto.setFlight((String)objects[5]);
            departTerminalDto.setTerminal((String)objects[6]);
            departTerminalDto.setStatus((String)objects[7]);
            departTerminalDto.setStatusTime((String)objects[8]);

            departTerminalDto.setBoardingClosed((String)objects[9]);
            departTerminalDto.setCheckInClosed((String)objects[10]);
            departTerminalDto.setType((String)objects[11]);

            list.add(departTerminalDto);
        });
        return list;
    }



}
