package com.raiff.java.blackjack;

/*
   Класс наследник класса Hand, который представляет руку в блекджеке
   Наследует методы класса Hand, но также реализует метод
   getBlackjackHandValue() - который возвращает значение руки.
*/
/*
Напиши программу, которая позволит поиграть в blackjack(двадцать одно). Правда, несколько упрощенную.
Компьютер будет играть роль дилер.
Тебе понадобятся следующие классы:
- Card – представляет собой карту
- Deck – представляет собой колоду
- Hand - представляет собой руку
- BlackjackHand - представляет собой руку в Blackjack

Ты должен написать подпрограмму(метод) в котором проходит одна партия игры. Метод должен возвращать булево значение, показывающее выиграл пользователь или проиграл.
Возвращай true если пользователь выиграл и false, если проиграл.
В программе потребуется один объект класса Deck и два объекта BlackjackHand, один для игрока другой для дилера

Основная цель в игре - получить руку где значение как можно ближе к 21, не превысив это число.
Игра идет следующим образом:

Сперва, две карты раздаются каждому из игроков.
Если после раздачи в руке дилера 21, то выиграл дилер.
Если после раздачи в руке игрока 21, то выиграл игрок.
В случае, если у обоих 21, то выигрывает дилер, потому что это казино)))

Теперь, если игра еще не закончилась, то игрок имеет право добавить карту к себе в руку.
В этой фазе игрок должен увидеть свои карты и одну из карт дилера
(В казино, дилер когда раздает, он кладет одну свою карту рубашкой вниз, а другую рубашкой вверх)
Игрок должен сделать выбор: или он "Добирает", то есть берет еще одну карту или "Останавливается", то есть больше не берет карты.

Если пользователь "Добирает" то есть вероятность, что он набрал больше 21. В этот момент игра заканчивается, игрок проигрывает.
Если у пользователя набралось не больше 21, то он снова должен выбрать "Добирать" или "остановиться"

Если пользователь "Останавливается" ход переходит к дилеру.
В нашей реализации дилер будет следовать простому правилу:
Если рука дилера меньше или равен 16, то дилер "добирает"

Когда у дилера больше 16, то он останавливается и можно определять победителя.
Если у дилера больше 21 то выиграл пользователь
Иначе если у дилера больше или одинаково с пользователем, то дилер выиграл
Иначе выиграл пользователь



 */
public class BlackjackHand extends Hand {

    public BlackjackHand(String name) {
        super(name);
    }

    // Возвращает значение руки в блекджеке
    public int getBlackjackValue() {

        int val;      // Значение руки
        boolean ace;  // Есть ли туз в руке
        int cards;    // Количество карт в руке

        val = 0;
        ace = false;
        cards = getCardCount(); // Метод должен быть реализован в классе Hand

        // Цикл Добавляет значение i-той карты в руке
        for (int i = 0; i < cards; i++) {

            Card card = getCard(i);    // i-я карта;
            int cardVal = card.getValue();  // Значение карты, от 1 до 13
            if (cardVal > 10) {
                cardVal = 10;   // Король, Валет, Дама.
            }
            if (cardVal == 1) {
                ace = true;     // Ставим true когда в руке есть хотя бы один туз
            }
            val = val + cardVal;
        }

        // Теперь в val создержится значение руки, где каждый туз считается как единица
        // Если есть туз, и если сменить его значение с 1 на 11
        // значение руки станет 21 или меньше то надо так и делать.

        if (ace == true && val + 10 <= 21)
            val = val + 10;

        return val;

    }
}