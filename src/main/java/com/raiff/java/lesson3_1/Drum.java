package com.raiff.java.lesson3_1;

public class Drum implements MusicalInstrument{

    private int sizeDrum; //размер барабана в см

    Drum(int sizeDrum){
        if (sizeDrum == 0){
            System.out.println("Барабан должен иметь размер в сантиметрах!");
            return;
        }
        this.sizeDrum = sizeDrum;

    }

    public int getSizeDrum() {
        return sizeDrum;
    }

    public void setSizeDrum(int sizeDrum) {
        this.sizeDrum = sizeDrum;
    }

    @Override
    public void play() {
        System.out.printf("Играет барабан размером %d см\n", sizeDrum);
    }
}
