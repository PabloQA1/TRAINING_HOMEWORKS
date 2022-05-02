package com.epam.training.hw_5;

public class FirstTask {

    private static int a;
    private static int p;
    private static double m1;
    private static double m2;

    public static void main(String[] args) {
            try {
                a = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[0] + " > must be an integer.");
                System.exit(1);
            }
            try {
                p = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[1] + " > must be an integer.");
                System.exit(1);
            }
            try {
                m1 = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[2] + " > must be an double.");
                System.exit(1);
            }
            try {
                m2 = Double.parseDouble(args[3]);
            } catch (NumberFormatException e) {
                System.err.println("Argument < " + args[3] + " > must be an double.");
                System.exit(1);
            }
            double G = 4 * Math.pow(Math.PI, 2) * Math.pow(a, 3) / (Math.pow(p, 2) * (m1 + m2));
            System.out.println(G);
    }
}

