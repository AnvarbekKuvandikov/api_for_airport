package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.UserCheckerDto;
import com.uz.aeroport.entity.UserCheckEntity;
import com.uz.aeroport.repository.UserRepository;
import com.uz.aeroport.service.CheckerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Created by Jack on 21.01.2019.
 */
@Service
public class CheckerServiceImpl implements CheckerService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCheckerDto getChecker()
    {
        UserCheckerDto userCheckerDto = new UserCheckerDto();
        String ff = "Admin";
        UserCheckEntity userCheckEntity = userRepository.findByLogin(ff);
        BeanUtils.copyProperties(userCheckEntity,userCheckerDto);
        return userCheckerDto;
    }

    @Override
    public boolean updatePassword(UserCheckerDto userCheckerDto)
    {
        System.out.println(userCheckerDto.getPassword());
        System.out.println(userCheckerDto.getOldPassword());
        String stringToHash = userCheckerDto.getOldPassword();
        String stringToHash1 = userCheckerDto.getPassword();
        MessageDigest messageDigest = null;
        try
        {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        messageDigest.update(stringToHash.getBytes());
        byte[] dig = messageDigest.digest();
        String HashedOutPut = DatatypeConverter.printHexBinary(dig);
        messageDigest.update(stringToHash1.getBytes());
        dig = messageDigest.digest();
        String HashedOutPut1 = DatatypeConverter.printHexBinary(dig);
        userCheckerDto.setOldPassword(HashedOutPut);
        userCheckerDto.setPassword(HashedOutPut1);
        Optional<UserCheckEntity> userCheckEntityOptional = userRepository.findByPassword(userCheckerDto.getOldPassword());
        if(userCheckEntityOptional.isPresent())
        {
            UserCheckEntity userCheckEntity = userCheckEntityOptional.get();
            userCheckEntity.setOldPassword(userCheckerDto.getPassword());
            userCheckEntity.setPassword(userCheckerDto.getPassword());
            userRepository.save(userCheckEntity);
            return true;
        }
        return false;
    }
}
