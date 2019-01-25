package com.uz.aeroport.entity;

import javax.persistence.*;

/**
 * Created by Jack on 25.01.2019.
 */
@Entity
@Table(name = "airLines")
public class AirLinesEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nameAirline;

    @Lob
    @Column(length = 100000)
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
