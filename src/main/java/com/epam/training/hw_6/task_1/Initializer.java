package com.epam.training.hw_6.task_1;

import java.util.Arrays;

public class Initializer {

    protected static boolean booleanValue;
    protected static float floatValue;
    protected static double doubleValue;
    protected static int intValue;
    protected static byte byteValue;
    protected static short shortValue;
    protected static long longValue;
    protected static char charValue;
    protected static String stringValue;
    protected static int[] arrayValue;
    protected static final String PRINT_MESSAGE = " default value is: ";

    public static void main(String... args) {
        System.out.println("Boolean" + PRINT_MESSAGE + booleanValue + "\n" +
                "Float" + PRINT_MESSAGE + floatValue + "\n" +
                "Double" + PRINT_MESSAGE + doubleValue + "\n" +
                "Integer" + PRINT_MESSAGE + intValue + "\n" +
                "Byte" + PRINT_MESSAGE + byteValue + "\n" +
                "Short" + PRINT_MESSAGE + shortValue + "\n" +
                "Long" + PRINT_MESSAGE + longValue + "\n" +
                "Char" + PRINT_MESSAGE + charValue + "\n" +
                "String" + PRINT_MESSAGE + stringValue + "\n" +
                "Array" + PRINT_MESSAGE + Arrays.toString(arrayValue));
    }
}
