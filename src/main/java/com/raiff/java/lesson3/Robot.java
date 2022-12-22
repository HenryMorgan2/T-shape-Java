package com.raiff.java.lesson3;

public class Robot implements Participant {
    private int jumpHeight = 1; //в метрах
    private int length = 100; //в метрах

    @Override
    public void runn(int obstacleLength){
        if (length < obstacleLength){
            System.out.println("Робот не смог пробежать");
        }else {
            System.out.println("Робот смог пробежать");
        }
    }
    @Override
    public void jump(int obstacleHeight){
        if (jumpHeight < obstacleHeight){
            System.out.println("Робот не смог перепрыгнуть");
        }else {
            System.out.println("Робот смог перепрыгнуть");
        }
    }

    @Override
    public String toString(){
        return "jumpHeight: " + jumpHeight + "; length: " + length;
    }

}
