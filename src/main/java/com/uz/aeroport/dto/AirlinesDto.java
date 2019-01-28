package com.uz.aeroport.dto;

/**
 * Created by Jack on 25.01.2019.
 */
public class AirlinesDto
{
    private Long id;
    private String image;
    private String nameAirline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }
}
