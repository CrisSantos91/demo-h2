package com.example.jwt.model;

import com.example.jwt.entity.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class CardsDTO {

//    utilizei o JsonIgnore, pois por conta do relacionamento pode dar recursão ifinita
//    ao serializar o objeto para Json
    @JsonIgnore
    private List<CardsDTO> cardsDTOS = new ArrayList<>();;
    private int id;
    private String type;
    private String category;
    private UsuarioDTO userId;

    public List<CardsDTO> getCardsDTOS() {
        return cardsDTOS;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public List<CardsDTO> toDTO(List<Card> cards) {
        if (cards == null) {
            return cardsDTOS;
        }
        for (Card c : cards) {
            this.id = c.getId();
            this.category = c.getCategory();
            this.type = c.getType();
            cardsDTOS.add(this);
        }
        return cardsDTOS;
    }

    @Override
    public String toString() {
        return "id=" + id + ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public UsuarioDTO getUserId() {
        return userId;
    }
}
