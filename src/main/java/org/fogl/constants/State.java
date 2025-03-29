package org.fogl.constants;

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

    public boolean isEndState() {
        return isEndState;
    }

}
