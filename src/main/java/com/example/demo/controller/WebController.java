package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Nominal;
import com.example.demo.model.Suit;
import com.example.demo.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// info
@Controller
@RequestMapping("/ui")
public class WebController {
    @Autowired
    GameServiceImpl service;

    @RequestMapping("/init")
    public String initGame(Model model) {
        service.init();
        service.shuffleDeck();
        return "redirect:/ui/refill";
    }

    @RequestMapping("/shuffle")
    public String shuffleDeck(Model model) {
        service.shuffleDeck();
        model.addAttribute("count", service.countDeck());
        Card card = new Card();
        card.setImg("/img/fulldeck/back.png");
        model.addAttribute("card", card);
        model.addAttribute("trump", service.getTrumpCard());
        return "gametable";
    }

    @RequestMapping("/refill/{amount}")
    public String refill(Model model, @PathVariable("amount") int amount) {
        model.addAttribute("list", service.giveMeCards());
        model.addAttribute("count", service.countDeck());
        model.addAttribute("trump", service.getTrumpCard());
        return "gametable";
    }

    @RequestMapping("/refill")
    public String refill(Model model) {
        model.addAttribute("message", service.getMyTurn());
        model.addAttribute("list", service.giveMeCards());
        model.addAttribute("listComp", service.giveCompCards());
        model.addAttribute("compMove", service.getCompMove());
        model.addAttribute("myMove", service.getMyMove());
        model.addAttribute("count", service.countDeck());
        model.addAttribute("trump", service.getTrumpCard());
        return "gametable";
    }

    @RequestMapping("/pick/{suit}/{nominal}")
    public String pick(Model model,
                       @PathVariable("suit") Suit suit,
                       @PathVariable("nominal") Nominal nominal) {
        Card card = service.getCard(suit, nominal);
        if (service.getCompMove().size() != service.getMyMove().size() + 1 && card != null) {
            if (service.getMyTurn() == false && service.getCompMove().size() == service.getMyMove().size()) {
                return "redirect:/ui/compturn";
            }
            model.addAttribute("message", service.getMyTurn());
            model.addAttribute("list", service.getRefill());
            model.addAttribute("listComp", service.getRefillComp());
            model.addAttribute("count", service.countDeck());
            model.addAttribute("myMove", service.getMyMove());
            model.addAttribute("compMove", service.getCompMove());
            model.addAttribute("trump", service.getTrumpCard());
            return "redirect:/ui/refill";
        }

        model.addAttribute("message", service.getMyTurn());
        model.addAttribute("list", service.getRefill());
        model.addAttribute("listComp", service.getRefillComp());
        model.addAttribute("count", service.countDeck());
        model.addAttribute("myMove", service.getMyMove());
        model.addAttribute("compMove", service.getCompMove());
        model.addAttribute("trump", service.getTrumpCard());
        return "redirect:/ui/refill";
    }

    @RequestMapping("/computermove")
    public String pick(Model model) {
        service.getCompMoveMethod();
        model.addAttribute("message", service.getMyTurn());
        model.addAttribute("list", service.getRefill());
        model.addAttribute("listComp", service.getRefillComp());
        model.addAttribute("count", service.countDeck());
        model.addAttribute("myMove", service.getMyMove());
        model.addAttribute("compMove", service.getCompMove());
        model.addAttribute("trump", service.getTrumpCard());
        return "redirect:/ui/refill";
    }

    @RequestMapping("/trash")
    public String trash(Model model) {
        service.throwTrash();
        service.giveMeCards();
        service.giveCompCards();
        if (service.getMyTurn() == false) {
            return "redirect:/ui/compturn";
        }
        model.addAttribute("message", service.getMyTurn());
        model.addAttribute("list", service.getRefill());
        model.addAttribute("listComp", service.getRefillComp());
        model.addAttribute("count", service.countDeck());
        model.addAttribute("myMove", service.getMyMove());
        model.addAttribute("compMove", service.getCompMove());
        model.addAttribute("trump", service.getTrumpCard());
        return "redirect:/ui/refill";
    }

    @RequestMapping("/compturn")
    public String compPick(Model model) {
        service.compPick();
        model.addAttribute("message", service.getMyTurn());
        model.addAttribute("list", service.getRefill());
        model.addAttribute("listComp", service.getRefillComp());
        model.addAttribute("count", service.countDeck());
        model.addAttribute("myMove", service.getMyMove());
        model.addAttribute("compMove", service.getCompMove());
        model.addAttribute("trump", service.getTrumpCard());
        return "redirect:/ui/refill";
    }
}
