package com.epam.training.hw_5;

public class SecondTask {

    private static int algorithmId;
    private static int loopType;
    private static int n;

    public static void main(String[] args) {
        for (String ignored : args) {
            try {
                algorithmId = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[0] + " > must be an integer.");
                System.exit(1);
            }
            try {
                loopType = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[1] + " > must be an integer.");
                System.exit(1);
            }
            try {
                n = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[2] + " > must be an integer.");
                System.exit(1);
            }
            executeCalculateByInputId();
            break;
        }
    }

    public static void executeCalculateByInputId() {
        if (algorithmId == 1) {
            calculateSeriesOfFibonacciNumbers();
        } else if (algorithmId == 2) {
            calculateFactorial();
        } else {
            throw new IllegalArgumentException("Input args must be 1 or 2");
        }
    }

    public static void calculateSeriesOfFibonacciNumbers() {
        switch (loopType) {
            case 1:
                calculateSeriesOfFibonacciNumbersByWhileLoop();
                break;
            case 2:
                calculateSeriesOfFibonacciNumbersByDoWhileLoop();
                break;
            case 3:
                calculateSeriesOfFibonacciNumbersByForLoop();
                break;
            default:
                throw new IllegalArgumentException("Input args must be from 1 to 3");
        }
    }

    public static void calculateFactorial() {
        switch (loopType) {
            case 1:
                calculateFactorialByWhileLoop();
                break;
            case 2:
                calculateFactorialByDoWhileLoop();
                break;
            case 3:
                calculateFactorialByForLoop();
                break;
            default:
                throw new IllegalArgumentException("Input args must be from 1 to 3");
        }
    }

    private static void calculateSeriesOfFibonacciNumbersByWhileLoop() {
        int a = 0;
        int b = 1;
        int i = 1;
        while (i <= n) {
            System.out.println(a);
            int temp = a + b;
            a = b;
            b = temp;
            i++;
        }
    }

    private static void calculateSeriesOfFibonacciNumbersByDoWhileLoop() {
        int a;
        int b = 1;
        int temp = 0;
        int i = 1;
        do {
            i++;
            System.out.println(temp);
            a = b;
            b = temp;
            temp = a + b;
        }
        while (i <= n);
    }

    private static void calculateSeriesOfFibonacciNumbersByForLoop() {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void calculateFactorialByWhileLoop() {
        int factorial = 1;
        int i = 1;
        while (i <= n) {
            factorial = factorial * i;
            i++;
        }
        System.out.println("Factorial of " + n + " is: " + factorial);
    }

    public static void calculateFactorialByDoWhileLoop() {
        int factorial = 1;
        int i = 1;
        do {
            factorial = factorial * i;
            i++;
        } while (i <= n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }

    public static void calculateFactorialByForLoop() {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}
