package com.uz.aeroport.repository;

import com.uz.aeroport.entity.AirLinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jack on 25.01.2019.
 */
public interface AirLinesRepository extends JpaRepository<AirLinesEntity,Long>
{

}
