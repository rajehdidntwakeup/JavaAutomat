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
            if (state == State.ERROR) {
                break;
            } else if (state == State.S) {
                state = getNextStateAfterS(c);
            } else if (state == State.A) {
                state = getNextStateAfterA(c);
            } else if (state == State.B) {
               state = getNextStateAfterBorZ(c);
            } else if (state == State.C) {
                state = getNextStateAfterC(c);
            } else if (state == State.D) {
                state = getNextStateAfterD(c);
            } else if (state == State.E) {
                state = getNextStateAfterE(c);
            } else if (state == State.F) {
                state = getNextStateAfterF(c);
            } else if (state == State.G) {
                state = getNextStateAfterG(c);
            } else if (state == State.Z) {
                state = getNextStateAfterBorZ(c);
            }
        }
        return state.isEndState();
    }


    public static String removeAllSpacesFromInput(String input){
        return input.replaceAll("\\s+", "");
    }

    public static State getNextStateAfterS(Character c){
        if (Transition.isNumber(c)) {
            return State.A;
        } else if (Transition.isOpeningBracket(c)) {
            return State.C;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterA(Character c) {
        if (Transition.isNumber(c)) {
            return State.A;
        } else if (Transition.isOperation(c)) {
            return State.S;
        } else if (Transition.isEquals(c)) {
            return State.B;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterBorZ(Character c){
        if (Transition.isNumber(c)) {
            return State.Z;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterC(Character c){
        if (Transition.isNumber(c)) {
            return State.D;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterD(Character c){
        if (Transition.isNumber(c)) {
            return State.D;
        } else if (Transition.isClosingBracket(c)) {
            return State.G;
        } else if (Transition.isOperation(c)) {
            return State.E;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterE(Character c){
        if (Transition.isNumber(c)) {
            return State.F;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterF(Character c){
        if (Transition.isNumber(c)) {
            return State.F;
        } else if (Transition.isClosingBracket(c)) {
            return State.G;
        } else if (Transition.isOperation(c)) {
            return State.C;
        }
        return State.ERROR;
    }

    public static State getNextStateAfterG(Character c){
        if (Transition.isOperation(c)) {
            return State.S;
        } else if (Transition.isEquals(c)) {
            return State.B;
        }
        return State.ERROR;
    }
}
