package com.raiff.java.lesson3;

public class Cat implements Participant{

    private int jumpHeight = 1; //в метрах
    private int length = 10; //в метрах

    @Override
    public void runn(int obstacleLength){
       if (length < obstacleLength){
           System.out.printf("Кот не смог пробежать, длина дорожки %s\n", obstacleLength);
       }else {
           System.out.printf("Кот смог пробежать, длина дорожки %s\n", obstacleLength);
       }
    }

    @Override
    public void jump(int obstacleHeight){
        if (jumpHeight < obstacleHeight){
            System.out.printf("Кот не смог перепрыгнуть, высота стены %s\n", obstacleHeight);
        }else {
            System.out.printf("Кот смог перепрыгнуть, высота стены %s\n", obstacleHeight);
        }
    }

    @Override
    public String toString(){
        return "jumpHeight: " + jumpHeight + "; length: " + length;
    }
}
