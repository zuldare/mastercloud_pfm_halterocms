package com.pfm.halterocms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
}
