package com.raiff.java.blackjack;

public class Card {

    private String suit; //масть карты
    private int point; //количество очков
    private String name; //название карты
    private Boolean used; //карта использована

    Card(String name, String suit, int point) {
        this.point = point;
        this.suit = suit;
        this.name = name;
        this.used = false;
    }

    public int getValue() {
        return point;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Boolean getUsed() {
        return used;
    }

    void infoCard() {

        if (point == 1){
            System.out.printf("Карта: %s %s , 1 или 11 очков за карту\n", name, suit, point);
        }else {

            System.out.printf("Карта: %s %s , %d очков за карту\n", name, suit, point);
        }
    }

}
