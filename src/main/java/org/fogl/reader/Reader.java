package org.fogl.reader;

import org.fogl.automat.DEAAutomat;
import org.fogl.constants.Color;

import java.io.*;
import java.util.List;

public class Reader {

    private static final int MIN_LINE_COUNT = 50;

    /**
     * Reads lines from a .txt file and checks each line using the DEA validator.
     *
     * @param path the path to the text file
     */
    public static void readFromFile(String path) {
        if (!path.toLowerCase().endsWith(".txt")) {
            System.out.println(Color.RED.getValue() +
                    "[ERROR] File must have a .txt extension" +
                    Color.RESET.getValue());
            return;
        }

        File file = new File(path);
        if (!file.exists()) {
            System.out.println(Color.RED.getValue() +
                    "[ERROR] File not found: " + path +
                    Color.RESET.getValue());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> lines = reader.lines().toList();

            if (lines.size() < MIN_LINE_COUNT) {
                System.out.println(Color.RED.getValue() +
                        "[ERROR] Not enough lines in the file: " + lines.size() +
                        Color.RESET.getValue());
                return;
            }

            lines.forEach(Reader::checkTheInputAndPrintTheResult);

        } catch (IOException e) {
            System.out.println(Color.RED.getValue() +
                    "[ERROR] Failed to read file: " + e.getMessage() +
                    Color.RESET.getValue());
            throw new RuntimeException(e);
        }
    }

    /**
     * Processes a mathematical equation provided via the console by validating its syntax.
     *
     * @param equation the equation string entered by the user to be checked
     */
    public static void readFromConsole(String equation) {
        checkTheInputAndPrintTheResult(equation);
    }

    /**
     * Validates the given input using a DEA-based syntax check and prints the result.
     *
     * @param input the string input to validate
     */
    public static void checkTheInputAndPrintTheResult(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(Color.RED.getValue() +
                    "[ERROR] No input provided!" +
                    Color.RESET.getValue());
            return;
        }

        if (DEAAutomat.DEA(input)) {
            System.out.println(Color.GREEN.getValue() +
                    "[SUCCESS] The input '" + input + "' is syntactically correct." +
                    Color.RESET.getValue());
        } else {
            System.out.println(Color.RED.getValue() +
                    "[ERROR] The input '" + input + "' is NOT syntactically correct." +
                    Color.RESET.getValue());
        }
    }
}
