package org.fogl.constants;

import java.util.List;

public enum Transition {
    NUMBER(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
    OPERATION(List.of('+', '-', '*', '/')),
    OPENING_BRACKET(List.of('(')),
    CLOSING_BRACKET(List.of(')')),
    EQUALS(List.of('=')),
    EMPTY(List.of());

    private List<Character> characters;

    Transition(List<Character> characters) {
        this.characters = characters;
    }

    public boolean isNumber(Character character) {
        return NUMBER.characters.contains(character);
    }

    public boolean isOperation(Character character) {
        return OPERATION.characters.contains(character);
    }

    public boolean isOpeningBracket(Character character) {
        return OPENING_BRACKET.characters.contains(character);
    }

    public boolean isClosingBracket(Character character) {
        return CLOSING_BRACKET.characters.contains(character);
    }

    public boolean isEquals(Character character) {
        return EQUALS.characters.contains(character);
    }

    public boolean isEmpty(Character character) {
        return EMPTY.characters.contains(character) || character == ' ';
    }
}
