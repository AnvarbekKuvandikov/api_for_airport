package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.DepartureDto;
import com.uz.aeroport.entity.DepartureEntity;
import com.uz.aeroport.repository.DepartureRepository;
import com.uz.aeroport.service.DepartureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        departureEntity.setDestination(departureDto.getDestination());
        departureEntity.setFlight(departureDto.getFlight());
        departureEntity.setStatus(departureDto.getStatus());
        departureEntity.setTerminal(departureDto.getTerminal());
        departureEntity.setTime(departureDto.getTime());
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
}
