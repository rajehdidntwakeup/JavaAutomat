package org.fogl.constants;

import lombok.Getter;

@Getter
public enum Color {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    RESET("\u001B[0m");

    private final String value;

    Color(String value) {
        this.value = value;
    }

}
