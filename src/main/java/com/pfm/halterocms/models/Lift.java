package com.pfm.halterocms.models;

import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

//TODO complete
public class Lift {

//    @OneToMany
    private BarSet barSet;

//    @Enumerated
    private LiftStatus status;

//    @Enumerated
    private LiftType type;

//TODO check Enumerated vs just number
    private Countdown countdown;


}
