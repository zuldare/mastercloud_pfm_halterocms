package com.pfm.halterocms.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Lifter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String club;

    @Column
    private String birthYear;

    @Column
    private String category;

    @Column
    private Integer competitionId;

    public Lifter() {
    }

    public Lifter(Integer competitionId) {
        this.competitionId = competitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lifter lifter = (Lifter) o;
        return Objects.equals(id, lifter.id) &&
                Objects.equals(competitionId, lifter.competitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, competitionId);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getCategory() {
        return category;
    }

    public Integer getCompetitionId(){
        return this.competitionId;
    }
}
