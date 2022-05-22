package com.epam.training.hw_11.task_1;

import java.util.Arrays;

public class ArraySort {

    private static final int[] ARRAY = {99, 88, 77, 66, 55, 44, 33, 22, 11, 10};

    public static int[] sortArray(int[] inputArray) {
        Arrays.sort(inputArray);
        return inputArray;
    }

    public static int[] getDigitsSumOfArrayElements(int[] inputArray) {
        int[] newArray = new int[inputArray.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = getDigitsSumOfOneNumber(inputArray[i]);
        }
        return newArray;
    }

    public static int getDigitsSumOfOneNumber(int number) {
        int result = 0;
        int x = Math.abs(number);
        while (x >= 10) {
            result += x % 10;
            x /= 10;
            result /= 10;
        }
        result += number;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(getDigitsSumOfArrayElements(ARRAY))));
    }
}
