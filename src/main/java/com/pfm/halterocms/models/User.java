package com.pfm.halterocms.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
