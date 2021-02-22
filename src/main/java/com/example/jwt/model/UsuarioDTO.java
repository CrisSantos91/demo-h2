package com.example.jwt.model;

import com.example.jwt.entity.Card;
import com.example.jwt.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDTO {

    private String first_name;
    private String last_name;
    private String career;
    private List<CardsDTO> cards;

    public List<CardsDTO> getCards(List<Card> cards) {
        this.cards =  new CardsDTO().toDTO(cards);
        return this.cards;
    }

    public List<CardsDTO> getCards() {
        return cards;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setCards(List<CardsDTO> cards) {
        this.cards = cards;
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        this.first_name = usuario.getFirst_name();
        this.last_name = usuario.getLast_name();
        this.career = usuario.getCareer();
        this.getCards(usuario.getCards());
        return this;
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

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", caree='" + career + '\'' +
                ", cards=" + cards +
                '}';
    }
}
