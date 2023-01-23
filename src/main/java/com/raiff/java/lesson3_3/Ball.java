package com.raiff.java.lesson3_3;

public abstract class Ball implements Tossable {
    protected String brandName;

    Ball(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    abstract void bounce();

    abstract public void toss();
}