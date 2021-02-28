package com.example.jwt.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "career")
    private String career;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user" )
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCareer() {
        return career;
    }

    public void setFirstname(String first_name) {
        this.first_name = first_name;
    }

    public void setLastname(String last_name) {
        this.last_name = last_name;
    }

    public void setCareer(String caree) {
        this.career = caree;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", caree='" + career + '\'' +
                ", cards=" + cards +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
