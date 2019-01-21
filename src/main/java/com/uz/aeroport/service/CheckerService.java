package com.uz.aeroport.service;

import com.uz.aeroport.dto.UserCheckerDto;

/**
 * Created by Jack on 21.01.2019.
 */
public interface CheckerService {
    UserCheckerDto getChecker();

    boolean updatePassword(UserCheckerDto userCheckerDto);
}
