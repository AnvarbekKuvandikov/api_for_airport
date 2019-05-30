package com.uz.aeroport.dto;

/**
 * Created by Jack on 29.01.2019.
 */
public class DepartTerminalDto {
    private String time;
    private String logo;
    private String flight;
    private String destinationUzb;
    private String destinationEng;
    private String destinationRus;
    private String status;
    private String statusTime;
    private String terminal;
    private String boardingClosed;
    private String checkInClosed;
    private String type;

    public String getBoardingClosed() {
        return boardingClosed;
    }

    public void setBoardingClosed(String boardingClosed) {
        this.boardingClosed = boardingClosed;
    }

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

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }
}
