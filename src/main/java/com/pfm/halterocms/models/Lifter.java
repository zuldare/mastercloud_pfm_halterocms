package com.pfm.halterocms.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Lifter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

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

    public Integer getCompetitionId(){
        return this.competitionId;
    }
}
