package com.raiff.java.lesson3_1;

public class Pipe implements MusicalInstrument{

    private int sizePipe; //размер трубы в см

    Pipe(int sizePipe){
        if (sizePipe == 0){
            System.out.println("Труба должна иметь диаметр в сантиметрах!");
            return;
        }
        this.sizePipe = sizePipe;
    }

    public int getSizePipe() {
        return sizePipe;
    }

    public void setSizePipe(int sizePipe) {
        this.sizePipe = sizePipe;
    }

    @Override
    public void play() {
        System.out.printf("Играет труба диаметром %d см\n", sizePipe);
    }
}
