package com.epam.training.hw_8.task_2;

public class SortingContext {

    private final Sorter sorter;

    public SortingContext(Sorter sorter) {
        this.sorter = sorter;
    }

    public int[] execute(int[] array) {
        return sorter.sort(array);
    }
}
