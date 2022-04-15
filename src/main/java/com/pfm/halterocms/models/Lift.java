package com.pfm.halterocms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer barSetWeight;

    @Column
    private String status;

    @Column
    private String type;

    @Column
    private Integer countdown;


    // TODO  check many to one and recursive
    @Column
    private Integer batchLifterId;

    public Lift() {
    }

    public Lift(Integer id, Integer barSetWeight, String status, String type, Integer countdown, Integer batchLifterId) {
        this.id = id;
        this.barSetWeight = barSetWeight;
        this.status = status;
        this.type = type;
        this.countdown = countdown;
        this.batchLifterId = batchLifterId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBarSetWeight() {
        return barSetWeight;
    }

    public void setBarSetWeight(Integer barSetWeight) {
        this.barSetWeight = barSetWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCountdown() {
        return countdown;
    }

    public void setCountdown(Integer countdown) {
        this.countdown = countdown;
    }

    public Integer getBatchLifterId() {
        return batchLifterId;
    }

    public void setBatchLifterId(Integer batchLifterId) {
        this.batchLifterId = batchLifterId;
    }

}
