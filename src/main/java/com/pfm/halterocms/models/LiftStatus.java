package com.pfm.halterocms.models;

public enum LiftStatus {
    PENDING("P"), VALID("V"), NULL("X"), REJECTED("R");

    private final String value;

    LiftStatus(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
