package com.raiff.java.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private static ArrayList<Card> deck; //колода с признаком использования карты

    private static int usedCard; //количество использованных карт

    Deck() {
        this.deck = createDeck();
    }

    //Увеличить количество использованных карт
    public static void increaseUsedCard() {
        Deck.usedCard++;
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

    //Получить не использованную карту из колоды
    public static Card getNotUsedCardFromDeck() {

        Random random = new Random();
        Card cardNotUsed = null;

        while (true) {

            if (usedAllCard()) {
                break;
            }

            cardNotUsed = deck.get(random.nextInt(51));
            if (!cardNotUsed.getUsed()) {
                increaseUsedCard();
                cardNotUsed.setUsed(true); //Делаем карту использованной
                break;
            }
        }

        return cardNotUsed;
    }

    public static boolean usedAllCard() {

        if (usedCard >= 52) {
            return true;
        }
        return false;
    }

}
