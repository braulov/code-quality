package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class State {
    protected FileReader file;
    protected CodeAnalyzer analyzer;
    protected ArrayList<String> currentLine;
    protected String currentWord;

    protected State(FileReader file, CodeAnalyzer analyzer) {
        this.file = file;
        this.currentWord = "";
        this.currentLine = new ArrayList<>();
        this.analyzer = analyzer;
    }

    protected State(State other) {
        this.file = other.file;
        this.currentLine = other.currentLine;
        this.currentWord = other.currentWord;
        this.analyzer = other.analyzer;
    }

    public boolean isClosed() {
        return false;
    }

    abstract State perform() throws IOException;

}
