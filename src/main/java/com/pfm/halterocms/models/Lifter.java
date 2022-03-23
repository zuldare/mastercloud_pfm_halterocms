package com.pfm.halterocms.models;

import javax.persistence.*;

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

    public Integer getCompetitionId(){
        return this.competitionId;
    }
}
