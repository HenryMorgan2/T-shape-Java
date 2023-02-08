package com.raiff.java.blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private String name;

    public Hand(String name) {
        this.name = name;
    }

    public void setCard(Card card) {
        this.cards.add(card);
    }

    // Количество карт в руке
    public int getCardCount() {
        return cards.size();
    }

    void infoCards() {
        System.out.printf("Карты %s\n", name);
        for (Card card : cards) {
            card.infoCard();
        }
    }

    // Значение карты в руке
    public Card getCard(int i) {
        return cards.get(i);
    }

    public String getName() {
        return name;
    }
}
