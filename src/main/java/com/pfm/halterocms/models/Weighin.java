package com.pfm.halterocms.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Weighin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Lifter lifter;

    @Column
    private Double bodyWeight;

    @Column
    private Integer snatchOpener;

    @Column
    private Integer cleanAndJerkOpener;

    @Column
    private LocalTime time;

    public Weighin(){}

    public Weighin(Lifter lifter, Double bodyWeight,
                   Integer snatchOpener, Integer cleanAndJerkOpener,
                   LocalTime time) {
        this.lifter = lifter;
        this.bodyWeight = bodyWeight;
        this.snatchOpener = snatchOpener;
        this.cleanAndJerkOpener = cleanAndJerkOpener;
        this.time = time;
    }

    public Weighin(Integer id, Lifter lifter, Double bodyWeight,
                   Integer snatchOpener, Integer cleanAndJerkOpener,
                   LocalTime time) {
        this.id = id;
        this.lifter = lifter;
        this.bodyWeight = bodyWeight;
        this.snatchOpener = snatchOpener;
        this.cleanAndJerkOpener = cleanAndJerkOpener;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weighin weighin = (Weighin) o;
        return Objects.equals(id, weighin.id) &&
                Objects.equals(lifter, weighin.lifter) &&
                Objects.equals(bodyWeight, weighin.bodyWeight) &&
                Objects.equals(snatchOpener, weighin.snatchOpener) &&
                Objects.equals(cleanAndJerkOpener, weighin.cleanAndJerkOpener) &&
                Objects.equals(time, weighin.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lifter, bodyWeight, snatchOpener, cleanAndJerkOpener, time);
    }

    public Integer getId() {
        return id;
    }

    public Lifter getLifter() {
        return lifter;
    }

    public Double getBodyWeight() {
        return bodyWeight;
    }

    public Integer getSnatchOpener() {
        return snatchOpener;
    }

    public Integer getCleanAndJerkOpener() {
        return cleanAndJerkOpener;
    }

    public LocalTime getTime() {
        return time;
    }
}
