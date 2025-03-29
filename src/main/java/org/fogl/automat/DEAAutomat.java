package org.fogl.automat;

import org.fogl.constants.State;
import org.fogl.constants.Transition;

public class DEAAutomat {

    public static boolean DEA(String input){
        /* DO sth */

        System.out.println("Original input: " + input);
        input = removeAllSpacesFromInput(input);
        System.out.println("Input without spaces : " + input);

        State state = State.S;
        for (char c : input.toCharArray()) {
            System.out.println("Character: " + c);
            System.out.println("State: " + state);
            if (state == State.S) {
                if (Transition.isNumber(c)) {
                    state = State.A;
                    continue;
                } else if (Transition.isOpeningBracket(c)) {
                    state = State.C;
                    continue;
                } else {
                    state = State.ERROR;
                    continue;
                }
            } else if (state == State.A) {
                if (Transition.isNumber(c)) {
                    state = State.A;
                    continue;
                } else if (Transition.isOperation(c)) {
                    state = State.S;
                    continue;
                } else if (Transition.isEquals(c)) {
                    state = State.B;
                    continue;
                }
            } else if (state == State.B) {

            }

        }


        return true;
    }


    public static String removeAllSpacesFromInput(String input){
        return input.replaceAll("\\s+", "");
    }
}
