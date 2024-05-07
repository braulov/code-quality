package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Empty extends State {
    Empty(FileReader file, CodeAnalyzer analyzer) {
        super(file, analyzer);
    }

    Empty(State other) {
        super(other);
    }

    State perform() throws IOException {
        int c = file.read();
        if (c == -1) return new End(this);
        else if ((char) c == '{') {
            currentLine.add("{");
            return new IsMethod(this);
        } else {
            if (!Character.isLetter((char) c) && c != '_') {
                if (currentWord.length() != 0) currentLine.add(currentWord);
                if ((char) c == '(' || (char) c == ')') {
                    currentLine.add(String.valueOf((char) c));
                }
                currentWord = "";
            } else {
                currentWord += (char) c;
            }
        }
        if (c == '\n') {
            currentLine = new ArrayList<>();
        }
        return new Empty(this);
    }
}
