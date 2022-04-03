package com.epam.training.hw_6.task_2;

public class Priority {

    static int a;
    int b;
    int c;

    {
        b = 2;
        System.out.println( "The 'regular' variable  will be printed second: " + b);
    }

    static  {
        a = 1;
        System.out.println("The 'static' variable will be printed first: " + a);
    }

    public static void main(String[] args) {
        Priority priority;
        priority = new Priority();
        priority.c = 3;
        System.out.println("The 'reference' variable will be printed third: " + priority.c);
    }
}
