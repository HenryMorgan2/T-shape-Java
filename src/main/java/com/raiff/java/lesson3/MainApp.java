package com.raiff.java.lesson3;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {

        Participant[] participants = new Participant[10];

        Random random = new Random();

        for (int i = 0; i < participants.length; i++) {
            int value = random.nextInt(3);

            if (value == 0) {
                participants[i] = new Cat();
            }
            if (value == 1) {
                participants[i] = new Human();
            }
            if (value == 2) {
                participants[i] = new Robot();
            }
        }


        Obstacle[] obstacles = new Obstacle[5];

        for (int i = 0; i < obstacles.length; i++) {
            int value = random.nextInt(2);

            int valueRunningTrack = random.nextInt(151);
            int valueWall = random.nextInt(4);

            if (value == 0) {
                obstacles[i] = new RunningTrack(valueRunningTrack);
            }
            if (value == 1) {
                obstacles[i] = new Wall(valueWall);
            }
        }


        for (Participant participant: participants) {
            System.out.println(participant.toString());
            for (Obstacle obstacle: obstacles) {
                obstacle.interact(participant);
            }
            System.out.println("\n");
        }
    }
}
