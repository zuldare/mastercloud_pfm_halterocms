package com.pfm.halterocms.models;

public enum Bar {
    FEMALE(15.0),
    MALE(20.0);

    private Double weight;

    Bar(Double weight) {
        this.weight = weight;
    }

    public Double getWeight(){
        return this.weight;
    }
}
