package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.ArriveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack on 26.12.2018.
 */
@RestController
@RequestMapping(value = "/arrive")
public class ArriveController
{

    public ResponseEntity<String> save(@RequestBody ArriveDto arriveDto)
    {
        return ResponseEntity.ok("soxranit bo`ldi");

    }
}
