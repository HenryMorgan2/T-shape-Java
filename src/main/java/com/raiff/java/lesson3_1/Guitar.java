package com.raiff.java.lesson3_1;

public class Guitar implements MusicalInstrument {

    private int numberOfStrings; //количество струн

    Guitar(int numberOfStrings) {
        if (numberOfStrings == 0) {
            System.out.println("Гитара не может быть без струн!");
            return;
        }
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play() {
        String declination = "струн";

        if (numberOfStrings == 1) {
            declination = "струна";
        }

        System.out.printf("Играет гитара у котрой %d %s\n", numberOfStrings, declination);
    }
}
