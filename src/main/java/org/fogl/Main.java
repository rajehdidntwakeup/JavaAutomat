package org.fogl;

import org.fogl.constants.Color;
import org.fogl.constants.StarterMsg;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.fogl.reader.Reader.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(Color.YELLOW.getValue() + StarterMsg.WELCOME.getValue() + Color.RESET.getValue());
        System.out.println(Color.YELLOW.getValue() + StarterMsg.MENU.getValue() + Color.RESET.getValue());

        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(Color.YELLOW.getValue() +
                            "[INFO] Enter the mathematical equation to validate, then press Enter:" +
                            Color.RESET.getValue() + "\n");
                    String equation = scanner.nextLine();
                    checkTheInputAndPrintTheResult(equation);
                    break;
                case 2:
                    System.out.println(Color.YELLOW.getValue() + "[INFO] Enter the file path: " + Color.RESET.getValue());
                    String filePath = scanner.nextLine();
                    readFromFile(filePath);
                    break;
                default:
                    System.out.println(Color.RED.getValue() +
                            "[ERROR] Sorry, but this mode does not exist." +
                            Color.RESET.getValue());
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(Color.RED.getValue() +
                    "[ERROR] Sorry, but there is something wrong with your input." +
                    Color.RESET.getValue());
        } finally {
            scanner.close();
        }
    }
}
