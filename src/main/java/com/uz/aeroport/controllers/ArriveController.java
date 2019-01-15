package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.ArriveDto;
import com.uz.aeroport.service.ArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Jack on 26.12.2018.
 */
@RestController
@RequestMapping(value = "/arrive")
public class ArriveController
{
    @Autowired
    private ArriveService arriveService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ArriveDto arriveDto)
    {
        return ResponseEntity.ok("Muvoffaqiyatli saqlandi");
    }
    @GetMapping
    public ResponseEntity <String> fetchResult(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate)
    {
        return ResponseEntity.ok(fromDate.toString());
    }
}
