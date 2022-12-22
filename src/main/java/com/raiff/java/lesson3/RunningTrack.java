package com.raiff.java.lesson3;

public class RunningTrack implements Obstacle {
    private int length = 150; //в метрах

    public RunningTrack(int valueRunningTrack) {
        this.length = valueRunningTrack;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void interact(Participant participant) {
        participant.runn(length);
    }
}
