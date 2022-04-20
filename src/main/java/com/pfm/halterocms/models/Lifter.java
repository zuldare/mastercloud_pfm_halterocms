package com.pfm.halterocms.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Lifter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String club;

    @Column
    private String birthYear;

    @Column
    private String category;

    @ManyToOne
    private Batch batch;

    public Lifter() {
    }

    public Lifter(Integer id, String name, String club, String birthYear, String category, Batch batch) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.birthYear = birthYear;
        this.category = category;
        this.batch = batch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lifter lifter = (Lifter) o;
        return Objects.equals(id, lifter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getCategory() {
        return category;
    }

    public Batch getBatch() {
        return batch;
    }

}
