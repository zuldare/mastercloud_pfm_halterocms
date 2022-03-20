package com.pfm.halterocms.models;

import javax.persistence.*;

@Entity
public class Lifter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String competitionId;
}
