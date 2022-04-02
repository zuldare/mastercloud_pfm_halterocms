package com.pfm.halterocms.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BatchLifter {

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

    public BatchLifter(){}

    public BatchLifter(Integer id, Integer drawOrder,
                       Batch batch, Lifter lifter, Weighin weighin) {
        this.id = id;
        this.drawOrder = drawOrder;
        this.batch = batch;
        this.lifter = lifter;
        this.weighin = weighin;
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
}
