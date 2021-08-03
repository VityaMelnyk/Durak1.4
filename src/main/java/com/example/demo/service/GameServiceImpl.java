package com.example.demo.service;

import com.example.demo.data.DataDeck;
import com.example.demo.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Service
public class GameServiceImpl implements  IGameService{

    private Game game;
    private Deque<Card> deck;
    List<Card> refill = new ArrayList<>();
    List<Card> refillComp = new ArrayList<>();
    List<Card> myMove = new ArrayList<>();
    List<Card> compMove = new ArrayList<>();
    Card empty = Card.builder().img("/img/fulldeck/back.png").build();
    List<Nominal> nominals = new ArrayList<>();
    Boolean myTurn = true;
    Boolean myGame = true;
    Suit trump = null;
    Card trumpCard = empty;


    @Autowired
    DataDeck data;


    @Override
    public void init() {
        deck = new LinkedList<>(data.getDeck());
        refill.clear();
        refillComp.clear();
        myMove.clear();
        compMove.clear();
        refillComp.clear();

    }
    public Card giveCard(){
        return deck.poll();
    }
    public void shuffleDeck(){
        List<Card> list = new ArrayList<>(deck);
        Collections.shuffle(list);
        deck = new LinkedList<>(list);
        trump = list.get(list.size()-1).getSuit();
        trumpCard = list.get(list.size()-1);
        for (Card card:list){
            if (card.getSuit().equals(trump)){
                card.setValue(card.getValue()+13);
            }
        }
    }
    public void removeCard(Card card){
        deck.removeFirstOccurrence(card);
    }
    public int countDeck(){
        if (deck==null){
            return 0;
        }
        return deck.size();
    }
    public List<Card> giveMeCards(){
        if (myMove.size() != 0 || compMove.size() != 0){
            return refill.stream().sorted(Comparator.comparing(Card::getValue))
                    .collect(Collectors.toList());
        }
        int cardsAmount = 6 - refill.size();
        for (int i = 0; i < cardsAmount; i++) {
                Card card = this.giveCard();
                if (card != null){
                    refill.add(card);
                }
            }
        refill = refill.stream().sorted(Comparator.comparing(Card::getValue))
                .collect(Collectors.toList());
        return refill;

    }
    public List<Card> giveCompCards(){
        if (myMove.size() != 0 || compMove.size() != 0){
            return refillComp.stream().sorted(Comparator.comparing(Card::getValue))
                    .collect(Collectors.toList());
        }
        int cardsAmount = 6 - refillComp.size();
        for (int i = 0; i < cardsAmount; i++) {
            Card card = this.giveCard();
            if (card != null){
                refillComp.add(card);
            }
        }
        return refillComp.stream().sorted(Comparator.comparing(Card::getValue))
                .collect(Collectors.toList());

    }
    public List<Card> addCard(){
        if (refill.size()<6) {
            Card card = this.giveCard();
            if (card != null){
                refill.add(card);
            }
        }
        return refill;
    }

    public Card getByImg(String img) {
        Card myPick = refill.stream().filter(card -> card.getImg().equals(img))
                .findFirst().orElse(null);
        refill.remove(myPick);
        myMove.add(myPick);
        return myPick;
    }
    public Card getCard(Suit suit, Nominal nominal) {

        if (this.myTurn == false && myMove.size() > compMove.size()) return null;        //////
            Card myPick = refill.stream()
                    .filter(card -> card.getNominal().equals(nominal))
                    .filter(card -> card.getSuit().equals(suit))
                    .findAny()
                    .orElse(empty);

        if (compMove.size() > myMove.size()){
                if (isMineGreater(myPick, compMove.get(compMove.size()-1))){
                    refill.remove(myPick);
                    myMove.add(myPick);
                    nominals.add(myPick.getNominal());

                    return myPick;
                } else {
                    return null;
                }
            }
        if (nominals.isEmpty() || nominals.contains(myPick.getNominal())) {
            refill.remove(myPick);
            myMove.add(myPick);
            nominals.add(myPick.getNominal());
        }
        if (nominals.isEmpty() || nominals.contains(myPick.getNominal())){
        }
        this.getCompMoveMethod();
        if (compMove.contains(empty)) {
        this.throwTrash();
        }
        return myPick;
    }

    public void getCompMoveMethod() {
        if (myMove.size() == compMove.size()){
            return;
        }
        Card move = myMove.get(myMove.size()-1);
        Card moveBack = fightBack(move, refillComp);
        refillComp.remove(moveBack);
        compMove.add(moveBack);
        nominals.add(moveBack.getNominal());

    }

    private Card fightBack(Card myMove, List<Card> compCards) {
       Suit suit = myMove.getSuit();
       List<Card> suits = refillComp.stream()
               .filter(el -> el.getSuit().equals(suit) || el.getSuit().equals(trump))
               .sorted(Comparator.comparing(Card::getValue))
               .collect(Collectors.toList());
       Card compMove = suits.stream().filter(el -> el.getValue() > myMove.getValue())
               .findFirst().orElse(empty);
       return compMove;
    }
    public List<Card> myPossibleFightBack() {
        Card card = compMove.get(compMove.size() - 1);
       Suit suit = card.getSuit();
       List<Card> allowed = refill.stream()
               .filter(el -> el.getSuit().equals(suit) || el.getSuit().equals(trump))
               .filter(el -> el.getValue() > card.getValue())
               .sorted(Comparator.comparing(Card::getValue))
               .collect(Collectors.toList());

       return allowed;
    }
    public boolean isMineGreater(Card mine, Card comp){
        if (mine.getSuit().equals(comp.getSuit())
                && mine.getValue() > comp.getValue()){
            return true;
        }
        if (mine.getSuit().equals(trump) && !comp.getSuit().equals(trump)){
            return true;
        }
        return false;
    }

    public void throwTrash() {
        nominals.clear();

        // Игрок забирает карты
        if (myMove.size() < compMove.size()){
            for (Card card:compMove){
                refill.add(card);
            }
            for (Card card:myMove) {
                refill.add(card);
            }
            this.myTurn = false;

        }

        // Комп забирает карты
        if (compMove.contains(empty)){
            compMove.remove(empty);
            for (Card card:compMove) {
                refillComp.add(card);
            }
            for (Card card:myMove)
                refillComp.add(card);
            this.myTurn = true;
        }
         if (myMove.size() == compMove.size()) this.myTurn = !myTurn;
        compMove.clear();
        myMove.clear();
        giveMeCards();
    }

    public void compPick(){
        // первый ход компа
        Card card = null;
        if (myMove.isEmpty()) {
            card = refillComp.stream().sorted(Comparator.comparing(Card::getValue))
                    .findFirst().orElse(null);
            if (refill.isEmpty()) {
                return;
            }
            refillComp.remove(card);
            compMove.add(card);
        }   else {
            Set<Nominal> nominals = new HashSet<>();
            for (Card card1:myMove) {
                nominals.add(card1.getNominal());
                for (Card card2 : compMove) {
                    nominals.add(card2.getNominal());

                }
                card = refillComp.stream().filter(el -> nominals.contains(el.getNominal()))
                        .findAny().orElse(null);
                if (card == null){
                    return;
                }
            }
        if (myMove.size() != compMove.size()){
            return;
        }
        // последующие ходы компа
        if (!myMove.isEmpty()){
                    if (!nominals.contains(card.getNominal())){
                        return;
                    }
            }
            myTurn = false;
            refillComp.remove(card);
            compMove.add(card);
            return;
        }
        }
    public void flipTurn() {
        myTurn = !myTurn;
    }
    // TODO Определить чей ход


}
