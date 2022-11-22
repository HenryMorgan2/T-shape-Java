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
        leapYear(2000);

        //11.
        int[] arr = {5, 25, 2, 1, 30, 1, 1, 1};
        System.out.println(checkBalanceArray(arr) ? "Есть баланс в массиве" : "Отсутствует баланс в массиве");
    }

    private static boolean checkBalanceArray(int[] arr) {
        boolean thereIsABalance = false;

        String textBalance = "";

        int sumValue = 0;

        for (int i = 0; i < arr.length; i++) {
            sumValue += arr[i];
        }
        if (sumValue % 2 == 0) {
            thereIsABalance = true;

            int balance = sumValue / 2;

            int sumBalance = 0;
            for (int i = 0; i < arr.length; i++) {
                sumBalance += arr[i];
                if (sumBalance == balance) {
                    textBalance += arr[i] + " || ";
                } else {
                    textBalance += arr[i] + (i == arr.length-1 ? "" : ", ");
                }
            }
        }

        System.out.println(textBalance);

        return thereIsABalance;
    }


    private static void diagonalArrayFilling() {
        int[][] twoDimensionalArray = new int[9][9];

        for (int j = 0; j < twoDimensionalArray.length; j++) {
            for (int k = 0; k < twoDimensionalArray.length; k++) {
                if (j == k) {
                    twoDimensionalArray[j][k] = 1;
                }
            }

        }
        //Есть ли возможность вывести строку массива стандартными методами?
    }


    public static boolean sumOfNumbersWithinValues(int firstNumber, int secondNumber) {
        boolean result = false;

        int sumOfNumbers = firstNumber + secondNumber;

        if (sumOfNumbers > 10 && sumOfNumbers <= 20) {
            result = true;
        }
        return result;
    }

    public static void printPositiveOrNegativeNumber(int number) {
        if (number >= 0) {
            System.out.println("Предано положительное число.");
        } else {
            System.out.println("Предано отрицательное число.");
        }
    }

    public static boolean negativeNumber(int number) {
        boolean result = false;

        if (number < 0) {
            result = true;
        }
        return result;
    }

    public static void printName(String name) {
        System.out.println("Привет, " + name);
    }

    private static void reverseValues() {
        int[] arr = {1, 0, 0, 1, 1, 1, 0, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    private static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i == 0 ? 2 : arr[i - 1] + 3;
        }
    }

    private static void processNumbersLessThanSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
    }

    private static void minAndMaxValueArray() {
        int[] arr = {5, 2, 0, 4, 3, 1};
        //Максимальный элемент
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int iCopy = arr[i];
                int jCopy = arr[j];
                if (jCopy > iCopy) {
                    arr[i] = jCopy;
                    arr[j] = iCopy;
                }
            }
        }
        System.out.println(arr[0]);

        //Минимальный элемент
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int iCopy = arr[i];
                int jCopy = arr[j];
                if (jCopy < iCopy) {
                    arr[i] = jCopy;
                    arr[j] = iCopy;
                }
            }
        }
        System.out.println(arr[0]);
    }

    public static void leapYear(int year) {
        boolean leapYear = false;

        if ((year % 4 == 0 & !(year % 100 == 0)) | ((year % 400 == 0) & year % 100 == 0)) {
            leapYear = true;
        }
        printYear(year, leapYear);
    }

    private static void printYear(int year, boolean leapYear) {
        System.out.println("Год " + year + (leapYear ? " " : " не ") + "високосный");
    }

}


