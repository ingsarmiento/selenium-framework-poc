package com.sarmiento.testautomation.selenium_framework_poc.util;

import java.util.Random;

public class RandomNumberGenerator {

    public static String get() {
        String firstNumber = randomNumber(111111111, 999999999);
        String secondNumber = randomNumber(11, 99);
        return String.format("%s%s", firstNumber, secondNumber);
    }

    private static String randomNumber(int min, int max) {
        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }
}
