package com.uz.aeroport.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jack on 25.01.2019.
 */
@Entity
@Table(name = "airLines")
public class AirLinesEntity implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nameAirline;


    @Column(length = 1000000 )
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
