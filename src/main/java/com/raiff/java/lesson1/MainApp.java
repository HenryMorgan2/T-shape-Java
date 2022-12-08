package com.raiff.java.lesson1;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        //1.
        System.out.println(sumOfNumbersWithinValues(10, 10));

        //2.
        printPositiveOrNegativeNumber(3);

        //3.
        System.out.println(negativeNumber(0));

        //4.
        printName("ВасЁк");

        //5.
        reverseValues();

        //6.
        fillArray();

        //7.
        processNumbersLessThanSix();

        //8.
        diagonalArrayFilling();

        //9.
        minAndMaxValueArray();

        //10.
        leapYear(2400);

        //11.
//        int[] arr = {1, 10, 3, 8, 8}; //нет баланса
        int[] arr = {1, 10, 1, 8, 2, 2}; // есть баланс

        System.out.println(checkBalanceArray(arr) ? "Есть баланс в массиве" : "Отсутствует баланс в массиве");
    }

    public static boolean sumOfNumbersWithinValues(int firstNumber, int secondNumber) {
        int sumOfNumbers = firstNumber + secondNumber;
        return sumOfNumbers > 10 && sumOfNumbers <= 20;
    }

    //Задача №2
    public static void printPositiveOrNegativeNumber(int number) {
        if (number >= 0) {
            System.out.println("Предано положительное число.");
        } else {
            System.out.println("Предано отрицательное число.");
        }
    }

    public static boolean negativeNumber(int number) {
        return number < 0;
    }

    //Задача № 4
    public static void printName(String name) {
        System.out.println("Привет, " + name);
    }

    //Задача № 5
    private static void reverseValues() {
        int[] arr = {1, 0, 0, 1, 1, 1, 0, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    //Задача № 6
    private static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 + i * 3;
        }
    }

    //Задача № 7
    private static void processNumbersLessThanSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
    }

    //Задача № 8
    private static void diagonalArrayFilling() {
        int[][] twoDimensionalArray = new int[9][9];

        for (int j = 0; j < twoDimensionalArray.length; j++) {
            twoDimensionalArray[j][j] = 1;
        }
        System.out.println(Arrays.deepToString(twoDimensionalArray));
        //Есть ли возможность вывести строку массива стандартными методами?
    }

    //Задача № 9
    private static void minAndMaxValueArray() {
        int[] arr = {5, 2, 0, 4, 3, 1};

        //Два варианта можно от первого элемента массива, либо от макимума или минимума от интеджер с подменой мин и макс
        int minValue = arr[0]; //Integer.MAX_VALUE;
        int maxValue = arr[0]; //Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue){
                minValue = arr[i];
            }
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        System.out.println("Max " + maxValue);
        System.out.println("Min " + minValue);

    }

    //Задача № 10
    public static void leapYear(int year) {
        boolean leapYear = false;

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            leapYear = true;
        }
        printYear(year, leapYear);
    }

    private static void printYear(int year, boolean leapYear) {
        System.out.println("Год " + year + (leapYear ? " " : " не ") + "високосный");
    }

    //Задача № 11
    private static boolean checkBalanceArray(int[] arr) {

        int sumArr = 0;

        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
        }
        if (sumArr % 2 != 0) {
            return false;
        }

        int sumBalance = sumArr/2;

        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            if (sumLeft == sumBalance){
                return true;
            }
        }

        return false;
    }

}


