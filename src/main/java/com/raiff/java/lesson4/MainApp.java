package com.raiff.java.lesson4;

public class MainApp {
    public static void main(String[] args) {

        String[][] arr = {{"4", "1", "3", "2"}, {"6", "8", "2", "4"}, {"6", "8k", "2", "4"}, {"6", "8", "2", "4"}};

        try {
            sumArr(arr);
        }catch (MyArrayDataException e){
            System.err.println(e.getCell());
        }

    }

    public static void sumArr(String[][] arr) {

        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Двумерный массив должен быть размером 4Х4");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать к числу", "[" + String.valueOf(i) + "][" + String.valueOf(j) + "]");
                }
            }
        }

        System.out.printf("Результат %d\n", sum);
    }
}
