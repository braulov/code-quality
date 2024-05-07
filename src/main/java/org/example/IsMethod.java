package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class IsMethod extends State {
    IsMethod(State other) {
        super(other);
    }

    State perform() {
        ArrayList<String> visionType = new ArrayList<>(Arrays.asList("private", "public", "protected"));
        String nameOfMethod;
        if (currentLine.contains("(")
                && currentLine.contains(")")
                && Objects.equals(currentLine.get(currentLine.size() - 1), "{")
                && !currentLine.contains("=")
                && !currentLine.contains("new")
                && !currentLine.contains("class")
                && !currentLine.contains("interface")) {
            if (visionType.contains(currentLine.get(0)) && currentLine.get(1).equals("static")) {
                nameOfMethod = currentLine.get(3);
            } else if (visionType.contains(currentLine.get(0)) || currentLine.get(0).equals("static")) {
                nameOfMethod = currentLine.get(2);
            } else {
                nameOfMethod = currentLine.get(1);
            }
            currentWord = "";
            currentLine = new ArrayList<>();
            return new ReadMethod(this, nameOfMethod);
        } else {
            currentWord = "";
            currentLine = new ArrayList<>();
            return new Empty(this);
        }
    }
}
