package com.raiff.java.lesson3;

public class Human implements Participant {
    private int jumpHeight = 1; //в метрах
    private int length = 100; //в метрах

    @Override
    public void runn(int obstacleLength) {
        if (length < obstacleLength) {
            System.out.printf("Человек не смог пробежать, длина дорожки %s\n", obstacleLength);
        } else {
            System.out.printf("Человек смог пробежать, длина дорожки %s\n", obstacleLength);
        }
    }

    @Override
    public void jump(int obstacleHeight) {
        if (jumpHeight < obstacleHeight) {
            System.out.printf("Человек не смог перепрыгнуть, высота стены %s\n", obstacleHeight);
        } else {
            System.out.printf("Человек смог перепрыгнуть, высота стены %s\n", obstacleHeight);
        }
    }

    @Override
    public String toString(){
        return "jumpHeight: " + jumpHeight + "; length: " + length;
    }

}
