package org.example;

import java.util.ArrayList;

public class AddMethod extends State {
    private final String nameOfMethod;
    private final ArrayList<String> words;

    AddMethod(ReadMethod other) {
        super(other);
        this.words = other.getWords();
        this.nameOfMethod = other.getNameOfMethod();
    }

    State perform() {
        this.analyzer.addMethod(nameOfMethod, words);
        return new Empty(this);
    }
}
