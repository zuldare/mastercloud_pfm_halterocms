package com.pfm.halterocms.models;

public enum Plate {
    BIG_RED(25.0),
    BIG_BLUE(20.0),
    BIG_YELLOW(15.0),
    BIG_GREEN(10.0),
    BIG_WHITE(5.0),
    SMALL_RED(2.5),
    SMALL_BLUE(2.0),
    SMALL_YELLOW(1.5),
    SMALL_GREEN(1.0),
    SMALL_WHITE(0.5);

    public Double weight;

    Plate(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return this.weight;
    }

}
