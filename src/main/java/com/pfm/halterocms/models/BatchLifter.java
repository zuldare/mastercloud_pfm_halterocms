package com.pfm.halterocms.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class BatchLifter {

    private static final int NUMBER_OF_LIFTS_BY_MOVEMENT = 3;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer drawOrder;

    @ManyToOne
    private Batch batch;

    @OneToOne
    private Lifter lifter;

    @OneToOne
    private Weighin weighin;

    @OneToMany
    @JsonManagedReference
    private List<Lift> lifts;

    public BatchLifter(){}

    public BatchLifter(Integer id, Integer drawOrder,
        Batch batch, Lifter lifter, Weighin weighin, List<Lift> lifts) {
        this.id = id;
        this.drawOrder = drawOrder;
        this.batch = batch;
        this.lifter = lifter;
        this.weighin = weighin;
        this.lifts = lifts;
    }

    public BatchLifter(Integer id, Integer drawOrder, Batch batch, Lifter lifter, Weighin weighin) {
        this.id = id;
        this.drawOrder = drawOrder;
        this.batch = batch;
        this.lifter = lifter;
        this.weighin = weighin;

        this.lifts = initializeType(LiftType.SNATCH);
        this.lifts.addAll(initializeType(LiftType.CLEAN_AND_JERK));
    }

    private List<Lift> initializeType(LiftType liftType){
        List<Lift> lifts = new ArrayList<>();
        for(int i=0;i< NUMBER_OF_LIFTS_BY_MOVEMENT;i++){
            Lift lift = new Lift();
            lift.setBatchLifterId(this.getId());
            lift.setStatus(LiftStatus.PENDING.getValue());
            lift.setType(liftType.getValue());
            lifts.add(lift);
        }
        return lifts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchLifter that = (BatchLifter) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(drawOrder, that.drawOrder) &&
                Objects.equals(batch, that.batch) &&
                Objects.equals(lifter, that.lifter) &&
                Objects.equals(weighin, that.weighin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drawOrder, batch, lifter, weighin);
    }

    public Integer getId() {
        return id;
    }

    public Integer getDrawOrder() {
        return drawOrder;
    }

    public Batch getBatch() {
        return batch;
    }

    public Lifter getLifter() {
        return lifter;
    }

    public Weighin getWeighin() {
        return weighin;
    }

    public void setWeighin(Weighin weighin) {
        this.weighin = weighin;
    }

    public List<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(List<Lift> lifts) {
        this.lifts = lifts;
    }
}
