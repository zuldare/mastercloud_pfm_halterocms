package com.pfm.halterocms.models;

public enum Countdown {
    ONE_MINUTE(60), TWO_MINUTES(120);

    private final Integer value;

    Countdown(Integer value) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }
}
