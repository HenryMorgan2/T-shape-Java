package com.raiff.java.lesson3_1;

import java.util.Random;

public class MainApp {

    public static void main(String[] args) {

        MusicalInstrument[] musicalInstruments = new MusicalInstrument[10];

        //Рандомное создание массива инструментов с рандомными свойствами
        Random randomInstruments = new Random();
        Random randomSize = new Random();

        for (int i = 0; i < musicalInstruments.length; i++) {

            int tipeInstrument = randomInstruments.nextInt(3);

            if (tipeInstrument == 0) {
                int propertyValue = randomSize.nextInt(8);
                musicalInstruments[i] = new Guitar(propertyValue);
            }

            if (tipeInstrument == 1) {
                int propertyValue = randomSize.nextInt(101);
                musicalInstruments[i] = new Drum(propertyValue);
            }
            if (tipeInstrument == 2) {
                int propertyValue = randomSize.nextInt(31);
                musicalInstruments[i] = new Pipe(propertyValue);
            }
        }


        for (MusicalInstrument arrayElement: musicalInstruments){
            arrayElement.play();
        }

    }
}
