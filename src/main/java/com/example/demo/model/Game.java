package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    private Suit trump;
    private Player firstPlayer;
    private Player secondPlayer;
    private List<Card> deck;
    private List<Card> trash;
    private Player turn;
    private Player firstTurn;

}
