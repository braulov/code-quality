package org.example;

public class End extends State {
    End(State other) {
        super(other);
    }

    public boolean isClosed() {
        return true;
    }

    State perform() {
        return this;
    }
}
