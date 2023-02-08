package com.raiff.java.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private static ArrayList<Card> deck; //колода с признаком использования карты

    Deck() {
        this.deck = createDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    private ArrayList<Card> createDeck() {

        ArrayList<Card> deck = new ArrayList<Card>();
        //Масти карт
        String[] suits = {"Червы", "Бубны", "Трефы", "Пики"};
        int[] points = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1};
        String[] names = {"2-ка", "3-ка", "4-ка", "5-ка", "6-ка", "7-ка", "8-ка", "9-ка", "10-ка", "Валет", "Дама", "Король", "Туз"};

        for (String suit : suits) {
            for (int i = 0; i < points.length; i++) {
                deck.add(new Card(names[i], suit, points[i]));
            }
        }

        return deck;
    }

    //Получение карты из колоды
    public static Card getCardFromDeck(int numberCard) {
        return deck.get(numberCard);
    }

    //Получить не использованную карту из колоды
    public static Card getNotUsedCardFromDeck() {

        Random random = new Random();
        Card cardNotUsed;

        while (true) {
            cardNotUsed = deck.get(random.nextInt(51));
            if (!cardNotUsed.getUsed()) {
                break;
            }
        }

        return cardNotUsed;
    }

}
