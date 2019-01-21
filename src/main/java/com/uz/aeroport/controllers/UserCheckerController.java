package com.uz.aeroport.controllers;

import com.uz.aeroport.dto.UserCheckerDto;
import com.uz.aeroport.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    public ResponseEntity<Boolean> setPassword(@PathVariable UserCheckerDto userCheckerDto) throws NoSuchAlgorithmException {
        String stringToHash = userCheckerDto.getPassword();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(stringToHash.getBytes());
        byte[] dig = messageDigest.digest();
        String HashedOutPut = DatatypeConverter.printHexBinary(dig);
        System.out.println(HashedOutPut);
        userCheckerDto.setPassword(HashedOutPut);
        boolean report =  checkerService.updatePassword(userCheckerDto);
        return ResponseEntity.ok(report);
    }

}
