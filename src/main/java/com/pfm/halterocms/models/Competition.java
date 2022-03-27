package com.pfm.halterocms.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String location;

    @Column
    private String organizer;

    @Column
    private LocalDate inscriptionStartDate;

    @Column
    private LocalDate inscriptionEndDate;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    public Competition() {
    }

    public Competition(Integer id,
                       String name, String type,
                       String location, String organizer,
                       LocalDate inscriptionStartDate, LocalDate inscriptionEndDate,
                       LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.organizer = organizer;
        this.inscriptionStartDate = inscriptionStartDate;
        this.inscriptionEndDate = inscriptionEndDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public LocalDate getInscriptionStartDate() {
        return inscriptionStartDate;
    }

    public LocalDate getInscriptionEndDate() {
        return inscriptionEndDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

}
