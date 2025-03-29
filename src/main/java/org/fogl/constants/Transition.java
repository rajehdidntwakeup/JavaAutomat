package org.fogl.constants;

import java.util.List;

public enum Transition {
    NUMBER(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
    OPERATION(List.of('+', '-', '*', '/')),
    OPENING_BRACKET(List.of('(')),
    CLOSING_BRACKET(List.of(')')),
    EQUALS(List.of('='));

    private final List<Character> characters;

    Transition(List<Character> characters) {
        this.characters = characters;
    }

    public static boolean isNumber(Character character) {
        return NUMBER.characters.contains(character);
    }

    public static boolean isOperation(Character character) {
        return OPERATION.characters.contains(character);
    }

    public static boolean isOpeningBracket(Character character) {
        return OPENING_BRACKET.characters.contains(character);
    }

    public static boolean isClosingBracket(Character character) {
        return CLOSING_BRACKET.characters.contains(character);
    }

    public static boolean isEquals(Character character) {
        return EQUALS.characters.contains(character);
    }

}
