package com.uz.aeroport.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jack on 26.12.2018.
 */
@Entity
@Table(name = "Arrive")
public class ArriveEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column
    private Date arriveDate;

    @Column
    private String time;

    @Column
    private String flight;

    @Column
    private String destinationUzb;

    @Column
    private String destinationRus;

    @Column
    private String destinationEng;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airlineId",insertable = false,updatable = false)
    private AirLinesEntity airLinesEntity;

    @Column(name = "airlineId")
    private Long airlineId;

    @Column
    private String statusTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
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

    public String getDestinationRus() {
        return destinationRus;
    }

    public void setDestinationRus(String destinationRus) {
        this.destinationRus = destinationRus;
    }

    public String getDestinationEng() {
        return destinationEng;
    }

    public void setDestinationEng(String destinationEng) {
        this.destinationEng = destinationEng;
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
