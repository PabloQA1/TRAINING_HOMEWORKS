package com.epam.training.hw_7.task_2;

import java.util.Arrays;

public class Median {
    public static float median(int[] array) {
        Arrays.sort(array);
        float median;
        int totalElements = array.length;
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = array[totalElements / 2] +
                    array[totalElements / 2 - 1];
            median =  (float) sumOfMiddleElements / 2;
        } else {
            median = array[array.length / 2];
        }
        return median;
    }

    public static double median(double[] array) {
        Arrays.sort(array);
        double median;
        int totalElements = array.length;
        if (totalElements % 2 == 0) {
            double sumOfMiddleElements = array[totalElements / 2] +
                    array[totalElements / 2 - 1];
            median = sumOfMiddleElements / 2;
        } else {
            median = array[array.length / 2];
        }
        return (float) median;
    }
}
