package com.uz.aeroport.service.impl;

import com.uz.aeroport.dto.UserCheckerDto;
import com.uz.aeroport.entity.UserCheckEntity;
import com.uz.aeroport.repository.UserRepository;
import com.uz.aeroport.service.CheckerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        Optional<UserCheckEntity> userCheckEntityOptional = userRepository.findByPassword(userCheckerDto.getPassword());
        if(userCheckEntityOptional.isPresent())
        {
            UserCheckEntity userCheckEntity = userCheckEntityOptional.get();
            userCheckEntity.setPassword(userCheckerDto.getPassword());
            userRepository.save(userCheckEntity);
            return true;
        }
        return false;
    }
}
