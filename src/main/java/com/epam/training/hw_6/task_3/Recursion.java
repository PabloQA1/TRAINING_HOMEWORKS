package com.epam.training.hw_6.task_3;

public class Recursion {

    public static void main(String[] args) {
        getCorrectNumberFibonacciRowWithLIntegerDataType();
        getCorrectNumberFibonacciRowWithLongDataType();
    }

    private static void getCorrectNumberFibonacciRowWithLIntegerDataType() {
        int[] arr = new int[10033333];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < 0) {
                System.out.println(i - 1);
                break;
            }
        }
    }

    private static void getCorrectNumberFibonacciRowWithLongDataType() {
        long[] arr = new long[100003207];
        arr[0] = 0;
        arr[1] = 1;
        for (long i = 2; i < arr.length; ++i) {
            arr[Math.toIntExact(i)] = arr[Math.toIntExact(i - 1)] + arr[Math.toIntExact(i - 2)];
        }
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < 0) {
                System.out.println(i - 1);
                break;
            }
        }
    }
}






