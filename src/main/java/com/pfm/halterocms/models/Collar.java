package com.pfm.halterocms.models;

public enum Collar {
    COLLAR(2.5);

    private Double weight;

    Collar(Double weight) {
        this.weight = weight;
    }

    public Double getWeight(){
        return this.weight;
    }
}
