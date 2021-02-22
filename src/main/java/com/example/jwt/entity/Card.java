package com.example.jwt.entity;

import javax.persistence.*;

@Entity(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario user;


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public Usuario getUser() {
        return user;
    }

}
