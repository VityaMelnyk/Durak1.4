package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Game;
import com.example.demo.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    GameServiceImpl service;

    @RequestMapping("/init")
    public void initGame(){
        service.init();
    }
    @RequestMapping("/getcard")
    public Card getCard(){
        return service.giveCard();
    }
    @RequestMapping("/shuffle")
    public String shuffleDeck(){
        service.shuffleDeck();

        return "Shuffled";
    }
    @RequestMapping("/remove1")
    public String remove1(){
        service.removeCard(service.giveCard());
        return "Card removed";
    }
    @RequestMapping("/count")
    public String countDeck(){
       return "" + service.countDeck();
    }
    @RequestMapping("/refill3")
    public List<Card> refill(){
        return service.giveMeCards();
    }
    @RequestMapping("/refill/{amount}")
    public List<Card> refill(@PathVariable("amount") int amount){
        return service.giveMeCards();
    }
}
