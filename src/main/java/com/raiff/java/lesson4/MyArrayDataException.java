package com.raiff.java.lesson4;

public class MyArrayDataException extends NumberFormatException{
    private String cell;

    public MyArrayDataException(String s, String cell) {
        super(s);
        this.cell = cell;
    }

    public String getCell() {
        return "Ошибка в ячейке: " + cell;
    }
}
