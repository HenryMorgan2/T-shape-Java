package com.raiff.java.blackjack;

public class Card {

    private final String suit; //масть карты
    private final int point; //количество очков
    private final String name; //название карты
    private boolean used; //карта использована

    Card(String name, String suit, int point) {
        this.point = point;
        this.suit = suit;
        this.name = name;
        this.used = false;
    }

    public int getValue() {
        return point;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    void infoCard() {

        if (point == 1) {
            System.out.printf("Карта: %s %s, 1 или 11 очков за карту\n", name, suit);
        } else {

            System.out.printf("Карта: %s %s, %d очков за карту\n", name, suit, point);
        }
    }

}