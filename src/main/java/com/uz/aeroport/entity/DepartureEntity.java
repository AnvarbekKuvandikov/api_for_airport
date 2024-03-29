package com.uz.aeroport.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jack on 26.12.2018.
 */
@Entity
@Table(name = "Depart")
public class DepartureEntity implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "TIMESTAMP without time zone default CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date departDate;

    @Column
    private String time;

    @Column
    private String flight;

    @Column
    private String destinationUzb;

    @Column
    private String destinationEng;

    @Column
    private String destinationRus;

    /*Qo`shimcha*/
    @Column
    private String type;

    @Column
    private String checkInClosed;

    @Column
    private String boardingClosed;

    /*Qo`shimcha*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckInClosed() {
        return checkInClosed;
    }

    public void setCheckInClosed(String checkInClosed) {
        this.checkInClosed = checkInClosed;
    }

    public String getBoardingClosed() {
        return boardingClosed;
    }

    public void setBoardingClosed(String boardingClosed) {
        this.boardingClosed = boardingClosed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airlineId",insertable = false,updatable = false)
    private AirLinesEntity airLinesEntity;

    @Column(name = "airlineId")
    private Long airlineId;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "statusTime")
    private String statusTime;

    @Column
    private String terminal;

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

    public AirLinesEntity getAirLinesEntity() {
        return airLinesEntity;
    }

    public void setAirLinesEntity(AirLinesEntity airLinesEntity) {
        this.airLinesEntity = airLinesEntity;
    }

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }
}
