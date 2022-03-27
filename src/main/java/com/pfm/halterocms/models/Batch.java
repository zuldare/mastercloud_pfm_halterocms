package com.pfm.halterocms.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Competition competition;

    @Column
    private String platform;

    @Column
    private String gender;

    @Column
    private LocalDate date;

    @Column
    private LocalTime weighinTime;

    @Column
    private LocalTime startTime;

    public Batch() {
    }

    public Batch(Integer id, Competition competition,
                 String platform, String gender,
                 LocalDate date, LocalTime weighinTime, LocalTime startTime) {
        this.id = id;
        this.competition = competition;
        this.platform = platform;
        this.gender = gender;
        this.date = date;
        this.weighinTime = weighinTime;
        this.startTime = startTime;
    }

    public Integer getId() {
        return id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public String getPlatform() {
        return platform;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getWeighinTime() {
        return weighinTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
}
