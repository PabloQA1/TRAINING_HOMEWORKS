package com.epam.training.hw_11.task_2;

import java.util.Arrays;
import java.util.HashSet;

public class Set {

    protected static final HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
    protected static final HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

    public static <T> java.util.Set<T> getSymmetricDifference(java.util.Set<? extends T> set1, java.util.Set<? extends T> set2) {
        java.util.Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        java.util.Set<T> tmp = new HashSet<>(set1);
        tmp.retainAll(set2);
        result.removeAll(tmp);
        return result;
    }

    public static <T> java.util.Set<T> getDifference(java.util.Set<? extends T> set1, java.util.Set<? extends T> set2) {
        java.util.Set<T> result = new HashSet<>(set1);
        result.removeIf(set2::contains);
        return result;
    }

    public static <T> java.util.Set<T> getIntesrsection(java.util.Set<? extends T> set1, java.util.Set<? extends T> set2) {
        java.util.Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static <T> java.util.Set<T> getUnion(java.util.Set<? extends T> set1, java.util.Set<? extends T> set2) {
        java.util.Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Symmetric difference is :" + getSymmetricDifference(set1, set2) + "\n" +
                "Difference is :" + getDifference(set1, set2) + "\n" +
                "Intersection is :" + getIntesrsection(set1, set2) + "\n" +
                "Union is :" + getUnion(set1, set2) + "\n");
    }
}
