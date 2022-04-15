package com.pfm.halterocms.models;

public enum LiftType {
    SNATCH("SN"), CLEAN_AND_JERK("C&J");

    private final String value;

    LiftType(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
