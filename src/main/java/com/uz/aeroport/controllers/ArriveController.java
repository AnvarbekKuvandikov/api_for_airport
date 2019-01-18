package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.ArriveDto;
import com.uz.aeroport.dto.DepartureDto;
import com.uz.aeroport.service.ArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @GetMapping
    public ResponseEntity <String> fetchResult(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate)
    {
        return ResponseEntity.ok(fromDate.toString());
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<ArriveDto> getOne(@PathVariable Long id)
    {
        ArriveDto arriveDto = arriveService.findOne(id);
        return ResponseEntity.ok(arriveDto);
    }
    @GetMapping(value = "/date={date}")
    public ResponseEntity<List<ArriveDto>> getFilterDate(@PathVariable String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date date1 = format.parse(date);
        System.out.println(date);
        List<ArriveDto> list = arriveService.getByFilter(date1);
        return ResponseEntity.ok(list);
    }
}
