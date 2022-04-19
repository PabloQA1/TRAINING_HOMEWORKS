package com.epam.training.hw_8.task_2;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    private static final int[] array = {13, 10, 6, 7, 2, 75, 2, 1};
    private static final String START_MESSAGE = "If you wont to sort array by Selection way PRESS <1> or PRESS <2> to sort by Bubble way";
    private static final String ALERT_MESSAGE = "KEYS must be 1 OR 2!";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(START_MESSAGE);
        int value = console.nextInt();
        SortingContext sortingContext;
        if (value == 1){
            sortingContext = new SortingContext(new SelectionSort());
        } else if (value == 2){
            sortingContext = new SortingContext(new BubbleSort());
        } else {
            throw new IllegalArgumentException(ALERT_MESSAGE);
        }
        System.out.println(Arrays.toString(sortingContext.execute(array)));
        console.close();
    }
}
