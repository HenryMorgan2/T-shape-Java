package com.raiff.java.lesson3;

public class Wall implements Obstacle {
    private int height = 2; //в метрах

    public Wall(int valueWall) {
        this.height = valueWall;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void interact(Participant participant) {
        participant.jump(height);
    }
}
