package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.DepartureDto;
import com.uz.aeroport.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jack on 26.12.2018.
 */
@RestController
@RequestMapping("/departure")
public class DepartureController
{
    @Autowired
    private DepartureService departureService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DepartureDto departureDto){
        departureService.create(departureDto);
        return ResponseEntity.ok("Muvofaqiyatli qo`shildi");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartureDto> getOne(@PathVariable Long id){
        DepartureDto departureDto = departureService.findOne(id);
        return ResponseEntity.ok(departureDto);
    }
    @GetMapping
    public  ResponseEntity<List<DepartureDto>> getAll()
    {
        List<DepartureDto> list = departureService.getAll();
        return ResponseEntity.ok(list);
    }


}
