package com.uz.aeroport.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jack on 26.12.2018.
 */
@Entity
@Table(name = "Depart")
public class DepartureEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date departDate;

    @Column
    private String time;

    @Column
    private String flight;

    @Column
    private String destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
}
