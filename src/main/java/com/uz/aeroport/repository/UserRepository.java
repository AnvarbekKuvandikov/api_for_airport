package com.uz.aeroport.repository;

import com.uz.aeroport.entity.UserCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by Jack on 21.01.2019.
 */
public interface UserRepository extends JpaRepository<UserCheckEntity,Long>
{
    @Query(value = "select id,login,passwords from userss where passwords = (:password)",nativeQuery = true)
    Optional<UserCheckEntity> findByPassword(@Param("password") String password);

    @Query(value = "select id,login,passwords from userss where login = (:admin)",nativeQuery = true)
    UserCheckEntity findByLogin(@Param("admin") String admin);
}
