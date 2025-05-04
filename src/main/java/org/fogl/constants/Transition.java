package org.fogl.constants;

import java.util.List;

public enum Transition {
    NUMBER(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
    OPERATION(List.of('+', '-', '*', '/')),
    OPENING_BRACKET(List.of('(')),
    CLOSING_BRACKET(List.of(')')),
    EQUALS(List.of('='));

    private final List<Character> characters;

    /**
     * Constructs a {@code Transition} with the specified list of characters.
     *
     * @param characters the characters associated with this transition
     */
    Transition(List<Character> characters) {
        this.characters = characters;
    }

    /**
     * Checks if the given character is a numerical digit.
     *
     * @param character the character to check
     * @return {@code true} if the character is a number, {@code false} otherwise
     */
    public static boolean isNumber(Character character) {
        return NUMBER.characters.contains(character);
    }


    /**
     * Checks if the given character is an arithmetic operation symbol.
     *
     * @param character the character to check
     * @return {@code true} if the character is an operation, {@code false} otherwise
     */
    public static boolean isOperation(Character character) {
        return OPERATION.characters.contains(character);
    }

    /**
     * Checks if the given character is an opening bracket '('.
     *
     * @param character the character to check
     * @return {@code true} if the character is an opening bracket, {@code false} otherwise
     */
    public static boolean isOpeningBracket(Character character) {
        return OPENING_BRACKET.characters.contains(character);
    }

    /**
     * Checks if the given character is a closing bracket ')'.
     *
     * @param character the character to check
     * @return {@code true} if the character is a closing bracket, {@code false} otherwise
     */
    public static boolean isClosingBracket(Character character) {
        return CLOSING_BRACKET.characters.contains(character);
    }

    /**
     * Checks if the given character is an equals symbol '='.
     *
     * @param character the character to check
     * @return {@code true} if the character is an equals symbol, {@code false} otherwise
     */
    public static boolean isEquals(Character character) {
        return EQUALS.characters.contains(character);
    }

}
