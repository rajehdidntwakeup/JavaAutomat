package org.fogl.automat;

import org.fogl.constants.State;
import org.fogl.constants.Transition;

public class DFAAutomat {

    /**
     * Simulates a Deterministic Finite Automaton (DFA) to validate a given input string.
     * <p>
     * This method processes the input string character by character using a state machine.
     * It begins in the initial state {@code State.S} and transitions through other states
     * based on the input, using specific transition methods for each state.
     * <p>
     * All whitespace characters are removed from the input before processing. The method
     * prints the original input and the sanitized input (without spaces) for debugging purposes.
     * <p>
     * The method returns {@code true} if the final state after processing all characters
     * is an accepting (end) state, as determined by {@code state.isEndState()}; otherwise, it returns {@code false}.
     *
     * @param input the input string to evaluate using the DFA
     * @return {@code true} if the input string is accepted by the DFA, {@code false} otherwise
     */
    public static boolean DFA(String input){

        if (input == null || input.isEmpty()) {
            return false;
        }

        input = removeAllSpacesFromInput(input);

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


    /**
     * Removes all whitespace characters from the given input string.
     * <p>
     * This method uses a regular expression to find and remove all types
     * of whitespace characters, including spaces, tabs, and newline characters.
     *
     * @param input the input string from which whitespace should be removed
     * @return a new string with all whitespace characters removed;
     *         if the input is {@code null}, this method returns {@code null}
     */
    public static String removeAllSpacesFromInput(String input){
        return input.replaceAll("\\s+", "");
    }

    /**
     * Determines the next state after state S based on the given character.
     * <p>
     * This method evaluates the input character and returns the corresponding
     * next state according to the following rules:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), returns {@code State.A}.</li>
     *   <li>If the character is an opening bracket (as determined by {@code Transition.isOpeningBracket(c)}), returns {@code State.C}.</li>
     *   <li>For any other character, returns {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state S based on the character input
     */
    public static State getNextStateAfterS(Character c){
        if (Transition.isNumber(c)) {
            return State.A;
        } else if (Transition.isOpeningBracket(c)) {
            return State.C;
        }
        return State.ERROR;
    }


    /**
     * Determines the next state after state A based on the given character.
     * <p>
     * This method uses transition logic to decide the next {@code State}
     * after state A, following these rules:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), returns {@code State.A} (remain in A).</li>
     *   <li>If the character is a valid operation (as determined by {@code Transition.isOperation(c)}), returns {@code State.S}.</li>
     *   <li>If the character is an equals sign (as determined by {@code Transition.isEquals(c)}), returns {@code State.B}.</li>
     *   <li>For any other character, returns {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state A based on the character input
     */
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

    /**
     * Determines the next state after state B or Z based on the given character.
     * <p>
     * This method checks the input character and returns the next {@code State}
     * according to the following rule:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), returns {@code State.Z}.</li>
     *   <li>For any other character, returns {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state B or Z based on the character input
     */
    public static State getNextStateAfterBorZ(Character c){
        if (Transition.isNumber(c)) {
            return State.Z;
        }
        return State.ERROR;
    }

    /**
     * Determines the next state after state C based on the given character.
     * <p>
     * This method applies the transition logic for state C as follows:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), returns {@code State.D}.</li>
     *   <li>For any other character, returns {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state C based on the character input
     */
    public static State getNextStateAfterC(Character c){
        if (Transition.isNumber(c)) {
            return State.D;
        }
        return State.ERROR;
    }

    /**
     * Determines the next state after state D based on the given character.
     * <p>
     * This method uses the following transition rules from state D:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), remain in {@code State.D}.</li>
     *   <li>If the character is a closing bracket (as determined by {@code Transition.isClosingBracket(c)}), return {@code State.G}.</li>
     *   <li>If the character is a valid operation (as determined by {@code Transition.isOperation(c)}), return {@code State.E}.</li>
     *   <li>For any other character, return {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state D based on the character input
     */
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


    /**
     * Determines the next state after state E based on the given character.
     * <p>
     * This method applies the following transition logic from state E:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), returns {@code State.F}.</li>
     *   <li>For any other character, returns {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state E based on the character input
     */
    public static State getNextStateAfterE(Character c){
        if (Transition.isNumber(c)) {
            return State.F;
        }
        return State.ERROR;
    }

    /**
     * Determines the next state after state F based on the given character.
     * <p>
     * This method defines the transition logic from state F as follows:
     * <ul>
     *   <li>If the character is a number (as determined by {@code Transition.isNumber(c)}), remain in {@code State.F}.</li>
     *   <li>If the character is a closing bracket (as determined by {@code Transition.isClosingBracket(c)}), return {@code State.G}.</li>
     *   <li>If the character is a valid operation (as determined by {@code Transition.isOperation(c)}), return {@code State.C}.</li>
     *   <li>For any other character, return {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state F based on the character input
     */
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


    /**
     * Determines the next state after state G based on the given character.
     * <p>
     * This method handles transitions from state G using the following rules:
     * <ul>
     *   <li>If the character is a valid operation (as determined by {@code Transition.isOperation(c)}), returns {@code State.S}.</li>
     *   <li>If the character is an equals sign (as determined by {@code Transition.isEquals(c)}), returns {@code State.B}.</li>
     *   <li>For any other character, returns {@code State.ERROR}.</li>
     * </ul>
     *
     * @param c the character to evaluate for the state transition
     * @return the next {@code State} after state G based on the character input
     */
    public static State getNextStateAfterG(Character c){
        if (Transition.isOperation(c)) {
            return State.S;
        } else if (Transition.isEquals(c)) {
            return State.B;
        }
        return State.ERROR;
    }
}
