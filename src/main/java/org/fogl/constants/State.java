package org.fogl.constants;

public enum State {
    S(false, true),
    A(false, false),
    B(false, false),
    C(false, false),
    D(false, false),
    E(false, false),
    F(false, false),
    G(false, false),
    Z(true, false),
    ERROR(false, false),;

    private boolean isEndState;
    private boolean isStartState;

    State(boolean isEndState, boolean isStartState) {
        this.isEndState = isEndState;
        this.isStartState = isStartState;
    }

    public boolean isEndState() {
        return isEndState;
    }

    public boolean isStartState() {
        return isStartState;
    }
}
