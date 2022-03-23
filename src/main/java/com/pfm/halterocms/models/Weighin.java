package com.pfm.halterocms.models;

import javax.persistence.*;

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

    public Weighin(){}

    public Weighin(Lifter lifter, double bodyWeight, int snatchOpener, int cleanAndJerkOpener) {
        this.lifter = lifter;
        this.bodyWeight = bodyWeight;
        this.snatchOpener = snatchOpener;
        this.cleanAndJerkOpener = cleanAndJerkOpener;
    }

    public Lifter getLifter(){
        return this.lifter;
    }

}
