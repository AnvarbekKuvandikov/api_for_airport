package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.ArriveDto;
import com.uz.aeroport.service.ArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        arriveService.create(arriveDto);
        return ResponseEntity.ok("Muvoffaqiyatli saqlandi");
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<ArriveDto> getOne(@PathVariable Long id)
    {
        ArriveDto arriveDto = arriveService.findOne(id);
        return ResponseEntity.ok(arriveDto);
    }
    @GetMapping(value = "/date={date}")
    public ResponseEntity<List<ArriveDto>> getFilterDate(@PathVariable String date) throws ParseException {
        LocalDate date1 = LocalDate.parse(date);
        List<ArriveDto> list = arriveService.getByFilter(date1);
        return ResponseEntity.ok(list);
    }
    @GetMapping
    public ResponseEntity<List<ArriveDto>> getAll(){
        List<ArriveDto> list = new ArrayList<>();
        list = arriveService.getAll();
        return ResponseEntity.ok(list);
    }
    @PutMapping
    public ResponseEntity<String> changeArrival(@RequestBody ArriveDto arriveDto){
        arriveService.changedById(arriveDto);
        return ResponseEntity.ok("Changed");
    }
}
