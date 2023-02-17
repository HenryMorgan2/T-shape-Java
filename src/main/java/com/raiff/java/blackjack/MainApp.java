package com.raiff.java.blackjack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {

        //Создаем игроков
        BlackjackHand diller = new BlackjackHand("Диллер");
        BlackjackHand player = new BlackjackHand("Игрок");

        //Создаем колоду
        Deck deck = new Deck();
        creatDeck(deck);

        //Раздача
        razdacha(diller);
        razdacha(player);

        //Сыграть партию
        playGame(deck, diller, player);

    }

    public static void razdacha(Hand hand) {
        int kolKartNaRazdachy = 2;
        Random razdachaRnd = new Random();
        //Раздача игрокам по 2 карты рандомом
        for (int i = 0; i < kolKartNaRazdachy; i++) {

            Card card = Deck.getCardFromDeck(razdachaRnd.nextInt(51)); //nextInt Количество карт в колоде
            card.setUsed(true); //Карта взята из колоды
            hand.setCard(card);
        }
    }

    //Создать колоду
    public static void creatDeck(Deck deck) {
        ArrayList<Card> arrayList = deck.getDeck();
    }

    //Проверить выигрыш
    public static Boolean checkWinnings(BlackjackHand hand) {

        int blackjackValue = hand.getBlackjackValue();
        if (blackjackValue == 21) {
            return true;
        }

        return false;
    }

    public static Boolean checkLose(BlackjackHand hand) {

        int blackjackValue = hand.getBlackjackValue();
        if (blackjackValue > 21) {
            return true;
        }

        return false;
    }

    //Проверить перебор очков
    public static Boolean checkEnumeration(BlackjackHand hand) {

        int blackjackValue = hand.getBlackjackValue();
        if (blackjackValue > 21) {
            return true;
        }
        return false;
    }

    //Сыграть партию
    public static void playGame(Deck deck, BlackjackHand diller, BlackjackHand player) {
        //Однозначная победа
        boolean winnDiller = checkWinnings(diller);
        boolean winnPlayer = checkWinnings(player);

        //Однозначное поражение
        boolean loseDiller = checkLose(diller);
        boolean losePlayer = checkLose(player);

        //Проверка после раздачи
        if (winnDiller & !loseDiller) {
            //Вскрываем карты
            showMaps(diller, player);
            infoWinnDiller(diller);
        } else if (winnPlayer & !losePlayer) {
            showMaps(diller, player);
            infoWinnDiller(diller);
        } else { //Продолжаем партию

            System.out.println("Ход игрока");

            //Показать карту диллера
            Random random = new Random();
            Card cardDiller = diller.getCard(random.nextInt(diller.getCardCount()));
            System.out.println("Показываю карту диллера");
            cardDiller.infoCard();

            //Игрок должен решить добирает он или нет
            while (true) {
                //Игрок набрал 21
                if (checkWinnings(player)) {
                    winnPlayer = true;
                    break;
                }
                //Игрок перебрал
                if (checkEnumeration(player)) {
                    winnDiller = true;
                    break;
                }

                player.infoCards();

                System.out.println("Добираете(Y) или останавливаетесь(N)?");
                String playerChoice;

                while (true) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        playerChoice = reader.readLine().toUpperCase();
                        if (playerChoice.equals("Y") || playerChoice.equals("N")) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                //Дать еще карту игроку
                if (playerChoice.equals("Y")) {
                    Card card = deck.getNotUsedCardFromDeck();
                    card.setUsed(true); //Карта взята из колоды
                    player.setCard(card);
                    System.out.printf("Общее количество очков у игрока %d\n", player.getBlackjackValue());

                    //Игрок перебрал
                    if (checkEnumeration(player)) {
                        winnDiller = true;
                        break;
                    }

                } else {
                    break;
                }
            }

            //Переход хода к диллеру
            if (!winnDiller & !winnPlayer) {
                while (diller.getBlackjackValue() <= 16) {
                    System.out.println("Диллер добрал карту");
                    Card card = deck.getNotUsedCardFromDeck();
                    card.setUsed(true); //Карта взята из колоды
                    diller.setCard(card);

                    //Диллер перебрал
                    if (checkEnumeration(diller)) {
                        winnPlayer = true;
                        break;
                    }
                }
            }


            //Вскрываем карты
            showMaps(diller, player);

            if (winnDiller || (!winnDiller & !winnPlayer & diller.getBlackjackValue() >= player.getBlackjackValue())) {
                infoWinnDiller(diller);
            } else {
                infoWinnDiller(player);
            }
        }
    }

    //Показать карты
    public static void showMaps(BlackjackHand diller, BlackjackHand player) {
        System.out.println("");
        System.out.println("Вскрываем карты!");
        System.out.println("");
        diller.infoCards();
        System.out.printf("Общее количество очков %s\n", diller.getBlackjackValue());
        System.out.println("");
        player.infoCards();
        System.out.printf("Общее количество очков %s\n", player.getBlackjackValue());
    }

    public static void infoWinnDiller(BlackjackHand hand) {

        if (hand.getName().equals("Диллер")) {
            System.out.println("");
            System.out.println("****************");
            System.out.println("Выиграл диллер!");
            System.out.println("****************");
        } else {
            System.out.println("****************");
            System.out.println("Выиграл игрок!");
            System.out.println("****************");
        }
    }
}
