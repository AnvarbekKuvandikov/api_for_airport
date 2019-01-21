package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.UserCheckerDto;
import com.uz.aeroport.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jack on 21.01.2019.
 */
@RestController
@RequestMapping(value = "/checker")
public class UserCheckerController
{
    @Autowired
    private CheckerService checkerService;

    @GetMapping
    public ResponseEntity<UserCheckerDto> getLoginPassword(){
      UserCheckerDto userCheckerDto;
      userCheckerDto = checkerService.getChecker();
      return ResponseEntity.ok(userCheckerDto);
    }
    @PostMapping
    public ResponseEntity<Boolean> setPassword(@RequestBody UserCheckerDto userCheckerDto)  {
        boolean report =  checkerService.updatePassword(userCheckerDto);
        return ResponseEntity.ok(report);
    }

}
