package org.fogl;

import org.fogl.automat.DEAAutomat;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Heute programmieren wir einen Automaten");

        String input1 = "876+23=32";
        String input2 = "234-234-432+(43)=342";
        String input3 = "(56+34)-324*34 =43";
        String input4 = "234/433+(4234+23)=342";
        String input5 = "234+53+(34)v=43";
        String input6 = "3 * 4 + ( 443 + 534 ) - 43 / 43 + (43 + 44) = 234";

        List<String> inputList = Arrays.asList(input1, input2, input3, input4, input5, input6);

        for (int x = 1; x < inputList.size() + 1; x++) {
            boolean isCorrect = DEAAutomat.DEA(inputList.get(x-1));
            if (!isCorrect) {
                System.out.println("Error in DEA: input " + x);
            } else {
                System.out.println("Correct input " + x);
            }
        }
    }
}
