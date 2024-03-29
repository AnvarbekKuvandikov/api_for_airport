package com.uz.aeroport.dto;

import com.uz.aeroport.entity.Status;

import java.util.Date;

/**
 * Created by Jack on 26.12.2018.
 */
public class DepartureDto {
    private Long id;

    private Date departDate;


    private String time;

    private String flight;

    private String destinationUzb;

    private String destinationEng;

    private String destinationRus;

    private Status status;

    private String statusTime;

    private String terminal;

    private Long airlineId;

    private String type;

    private String checkInClosed;

    private String boardingClosed;

    public String getCheckInClosed() {
        return checkInClosed;
    }

    public void setCheckInClosed(String checkInClosed) {
        this.checkInClosed = checkInClosed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBoardingClosed() {
        return boardingClosed;
    }

    public void setBoardingClosed(String boardingClosed) {
        this.boardingClosed = boardingClosed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getDestinationUzb() {
        return destinationUzb;
    }

    public void setDestinationUzb(String destinationUzb) {
        this.destinationUzb = destinationUzb;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getDestinationEng() {
        return destinationEng;
    }

    public void setDestinationEng(String destinationEng) {
        this.destinationEng = destinationEng;
    }

    public String getDestinationRus() {
        return destinationRus;
    }

    public void setDestinationRus(String destinationRus) {
        this.destinationRus = destinationRus;
    }

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }
}
