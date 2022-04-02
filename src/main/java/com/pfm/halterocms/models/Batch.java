package com.pfm.halterocms.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany
    private final List<BatchLifter> lifters;

    public Batch() {
        this.lifters = new ArrayList<>();
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
        this.lifters = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(id, batch.id) &&
                Objects.equals(competition, batch.competition) &&
                Objects.equals(platform, batch.platform) &&
                Objects.equals(gender, batch.gender) &&
                Objects.equals(date, batch.date) &&
                Objects.equals(weighinTime, batch.weighinTime) &&
                Objects.equals(startTime, batch.startTime) &&
                Objects.equals(lifters, batch.lifters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, competition, platform, gender, date, weighinTime, startTime, lifters);
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

    public List<BatchLifter> getLifters() {
        return lifters;
    }
}
