package com.uz.aeroport.repository;

import com.uz.aeroport.entity.DepartureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jack on 26.12.2018.
 */
public interface DepartureRepository extends JpaRepository<DepartureEntity,Long> {

}