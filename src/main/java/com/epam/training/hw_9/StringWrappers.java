package com.epam.training.hw_9;

import org.jetbrains.annotations.NotNull;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringWrappers {

    private static final String SPLIT_STRING_INTO_SUBSTRINGS_REGEX = "\\b(\\w+)\\b\\s*(?=.*\\b\\1\\b)";
    private static final String REMOVE_PUNCTUATION_MARKS_REGEX = "\\s*(\\s|,|!|\\.)\\s*";

    public static void main(String[] args) {
        final String string = getText().replaceAll(SPLIT_STRING_INTO_SUBSTRINGS_REGEX, "");
        Pattern pattern = Pattern.compile(REMOVE_PUNCTUATION_MARKS_REGEX);
        final String[] words = pattern.split(string);
        printResult(words);
    }

    private static  String getText()  {
            System.out.println("Enter text:");
            Scanner scanner = new Scanner(System.in);
            String inputText = scanner.nextLine();
            scanner.close();
            return inputText;
    }

    private static void printResult(String @NotNull [] words) {
        for (int j = 0; j < words.length; j++) {
            for (int i = j + 1; i < words.length; i++) {
                if (words[i].compareToIgnoreCase(words[j]) < 0) {
                    String t = words[j];
                    words[j] = words[i];
                    words[i] = t;
                }
            }
            System.out.println(words[j].toUpperCase(Locale.ENGLISH).charAt(0) + ": " + words[j]);
        }
    }
}
