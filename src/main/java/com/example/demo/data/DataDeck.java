package com.example.demo.data;

import com.example.demo.model.Card;
import com.example.demo.model.Nominal;
import com.example.demo.model.Suit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataDeck {
    private List<Card> deck = new ArrayList<>(
            Arrays.asList(
                    new Card(Suit.P, Nominal.N2, 2, "/img/fulldeck/P2.png"),
                    new Card(Suit.H, Nominal.N2, 2, "/img/fulldeck/H2.png"),
                    new Card(Suit.T, Nominal.N2, 2, "/img/fulldeck/T2.png"),
                    new Card(Suit.C, Nominal.N2, 2, "/img/fulldeck/C2.png"),

                    new Card(Suit.P, Nominal.N3, 3, "/img/fulldeck/P3.png"),
                    new Card(Suit.H, Nominal.N3, 3, "/img/fulldeck/H3.png"),
                    new Card(Suit.T, Nominal.N3, 3, "/img/fulldeck/T3.png"),
                    new Card(Suit.C, Nominal.N3, 3, "/img/fulldeck/C3.png"),

                    new Card(Suit.P, Nominal.N4, 4, "/img/fulldeck/P4.png"),
                    new Card(Suit.H, Nominal.N4, 4, "/img/fulldeck/H4.png"),
                    new Card(Suit.T, Nominal.N4, 4, "/img/fulldeck/T4.png"),
                    new Card(Suit.C, Nominal.N4, 4, "/img/fulldeck/C4.png"),

                    new Card(Suit.P, Nominal.N5, 5, "/img/fulldeck/P5.png"),
                    new Card(Suit.H, Nominal.N5, 5, "/img/fulldeck/H5.png"),
                    new Card(Suit.T, Nominal.N5, 5, "/img/fulldeck/T5.png"),
                    new Card(Suit.C, Nominal.N5, 5, "/img/fulldeck/C5.png"),

                    new Card(Suit.P, Nominal.N6, 6, "/img/fulldeck/P6.png"),
                    new Card(Suit.H, Nominal.N6, 6, "/img/fulldeck/H6.png"),
                    new Card(Suit.T, Nominal.N6, 6, "/img/fulldeck/T6.png"),
                    new Card(Suit.C, Nominal.N6, 6, "/img/fulldeck/C6.png"),

                    new Card(Suit.P, Nominal.N7, 7, "/img/fulldeck/P7.png"),
                    new Card(Suit.H, Nominal.N7, 7, "/img/fulldeck/H7.png"),
                    new Card(Suit.T, Nominal.N7, 7, "/img/fulldeck/T7.png"),
                    new Card(Suit.C, Nominal.N7, 7, "/img/fulldeck/C7.png"),

                    new Card(Suit.P, Nominal.N8, 8, "/img/fulldeck/P8.png"),
                    new Card(Suit.H, Nominal.N8, 8, "/img/fulldeck/H8.png"),
                    new Card(Suit.T, Nominal.N8, 8, "/img/fulldeck/T8.png"),
                    new Card(Suit.C, Nominal.N8, 8, "/img/fulldeck/C8.png"),

                    new Card(Suit.P, Nominal.N9, 9, "/img/fulldeck/P9.png"),
                    new Card(Suit.H, Nominal.N9, 9, "/img/fulldeck/H9.png"),
                    new Card(Suit.T, Nominal.N9, 9, "/img/fulldeck/T9.png"),
                    new Card(Suit.C, Nominal.N9, 9, "/img/fulldeck/C9.png"),

                    new Card(Suit.P, Nominal.N10, 10, "/img/fulldeck/P10.png"),
                    new Card(Suit.H, Nominal.N10, 10, "/img/fulldeck/H10.png"),
                    new Card(Suit.T, Nominal.N10, 10, "/img/fulldeck/T10.png"),
                    new Card(Suit.C, Nominal.N10, 10, "/img/fulldeck/C10.png"),

                    new Card(Suit.P, Nominal.J, 11, "/img/fulldeck/PJ.png"),
                    new Card(Suit.H, Nominal.J, 11, "/img/fulldeck/HJ.png"),
                    new Card(Suit.T, Nominal.J, 11, "/img/fulldeck/TJ.png"),
                    new Card(Suit.C, Nominal.J, 11, "/img/fulldeck/CJ.png"),

                    new Card(Suit.P, Nominal.Q, 12, "/img/fulldeck/PQ.png"),
                    new Card(Suit.H, Nominal.Q, 12, "/img/fulldeck/HQ.png"),
                    new Card(Suit.T, Nominal.Q, 12, "/img/fulldeck/TQ.png"),
                    new Card(Suit.C, Nominal.Q, 12, "/img/fulldeck/CQ.png"),

                    new Card(Suit.P, Nominal.K, 13, "/img/fulldeck/PK.png"),
                    new Card(Suit.H, Nominal.K, 13, "/img/fulldeck/HK.png"),
                    new Card(Suit.T, Nominal.K, 13, "/img/fulldeck/TK.png"),
                    new Card(Suit.C, Nominal.K, 13, "/img/fulldeck/CK.png"),

                    new Card(Suit.P, Nominal.A, 14, "/img/fulldeck/PA.png"),
                    new Card(Suit.H, Nominal.A, 14, "/img/fulldeck/HA.png"),
                    new Card(Suit.T, Nominal.A, 14, "/img/fulldeck/TA.png"),
                    new Card(Suit.C, Nominal.A, 14, "/img/fulldeck/CA.png")
            )
    );

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
