package com.raiff.java.blackjack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {

        //Создаем игроков
        BlackjackHand dealer = new BlackjackHand("Диллер");
        BlackjackHand player = new BlackjackHand("Игрок");

        //Создаем колоду
        Deck deck = new Deck();

        //Раздача
        razdacha(dealer);
        razdacha(player);

        //Сыграть партию
        playGame(deck, dealer, player);

    }

    public static void razdacha(Hand hand) {
        int kolKartNaRazdachy = 2;
        Random razdachaRnd = new Random();
        //Раздача игрокам по 2 карты рандомом
        for (int i = 0; i < kolKartNaRazdachy; i++) {

            Card card = Deck.getNotUsedCardFromDeck();
            if (card == null) {
                throw new NullPointerException("Все карты сыграны!");
            }

            hand.addCard(card);
        }
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
    public static void playGame(Deck deck, BlackjackHand dealer, BlackjackHand player) {
        //Однозначная победа
        boolean winnDealer = checkWinnings(dealer);
        boolean winnPlayer = checkWinnings(player);

        //Однозначное поражение
        boolean loseDealer = checkLose(dealer);
        boolean losePlayer = checkLose(player);

        //Проверка после раздачи
        if (winnDealer & !loseDealer) {
            //Вскрываем карты
            showMaps(dealer, player);
            infoWinnDealer(dealer);
        } else if (winnPlayer & !losePlayer) {
            showMaps(dealer, player);
            infoWinnDealer(dealer);
        } else { //Продолжаем партию

            System.out.println("Ход игрока");

            //Показать карту диллера
            Random random = new Random();
            Card cardDealer = dealer.getCard(random.nextInt(dealer.getCardCount()));
            System.out.println("Показываю карту диллера");
            cardDealer.infoCard();

            //Игрок должен решить добирает он или нет
            while (true) {
                //Игрок набрал 21
                if (checkWinnings(player)) {
                    winnPlayer = true;
                    break;
                }
                //Игрок перебрал
                if (checkEnumeration(player)) {
                    winnDealer = true;
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
                    if (card == null) {
                        throw new NullPointerException("Все карты сыграны");
                    }
                    player.addCard(card);
                    System.out.printf("Общее количество очков у игрока %d\n", player.getBlackjackValue());

                    //Игрок перебрал
                    if (checkEnumeration(player)) {
                        winnDealer = true;
                        break;
                    }

                } else {
                    break;
                }
            }

            //Переход хода к диллеру
            if (!winnDealer & !winnPlayer) {
                while (dealer.getBlackjackValue() <= 16) {
                    Card card = deck.getNotUsedCardFromDeck();
                    if (card == null) {
                        throw new NullPointerException("Все карты сыграны");
                    }
                    dealer.addCard(card);
                    System.out.println("Диллер добрал карту");

                    //Диллер перебрал
                    if (checkEnumeration(dealer)) {
                        winnPlayer = true;
                        break;
                    }
                }
            }

            //Вскрываем карты
            showMaps(dealer, player);

            if (winnDealer || (!winnDealer & !winnPlayer & dealer.getBlackjackValue() >= player.getBlackjackValue())) {
                infoWinnDealer(dealer);
            } else {
                infoWinnDealer(player);
            }
        }
    }

    //Показать карты
    public static void showMaps(BlackjackHand dealer, BlackjackHand player) {
        System.out.println("");
        System.out.println("Вскрываем карты!");
        System.out.println("");
        dealer.infoCards();
        System.out.printf("Общее количество очков %s\n", dealer.getBlackjackValue());
        System.out.println("");
        player.infoCards();
        System.out.printf("Общее количество очков %s\n", player.getBlackjackValue());
    }

    public static void infoWinnDealer(BlackjackHand hand) {

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
