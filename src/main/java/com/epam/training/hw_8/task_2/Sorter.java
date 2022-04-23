package com.epam.training.hw_8.task_2;

public interface Sorter {

    default int[] sort(int[] array) {
        return array;
    }
}
