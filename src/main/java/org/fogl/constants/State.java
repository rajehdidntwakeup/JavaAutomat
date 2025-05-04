package org.fogl.constants;

import lombok.Getter;

@Getter
public enum State {
    S(false),
    A(false),
    B(false),
    C(false),
    D(false),
    E(false),
    F(false),
    G(false),
    Z(true),
    ERROR(false),;

    private final boolean isEndState;

    State(boolean isEndState) {
        this.isEndState = isEndState;
    }

}
