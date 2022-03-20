package com.pfm.halterocms.models;

import javax.persistence.*;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer competitionId;
}
