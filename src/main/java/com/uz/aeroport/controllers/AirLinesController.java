package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.AirlinesDto;
import com.uz.aeroport.service.AirLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jack on 25.01.2019.
 */
@RestController
@RequestMapping(value = "/airlines")
public class AirLinesController
{
    @Autowired
    private AirLinesService airLinesService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AirlinesDto airlinesDto){
        airLinesService.create(airlinesDto);
        return ResponseEntity.ok("Qo`shildi");
    }

    @GetMapping
    public ResponseEntity<AirlinesDto> getById(@PathVariable Long id)
    {
        AirlinesDto airlinesDto = airLinesService.getById(id);
        return ResponseEntity.ok(airlinesDto);
    }
}
