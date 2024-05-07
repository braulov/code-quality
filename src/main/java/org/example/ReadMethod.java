package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class ReadMethod extends State {
    private final String nameOfMethod;
    private final ArrayList<String> words;
    private int balanceScope = 1;

    ReadMethod(State other, String nameOfMethod) {
        super(other);
        this.nameOfMethod = nameOfMethod;
        if (other instanceof ReadMethod) {
            this.words = ((ReadMethod) other).getWords();
            this.balanceScope = ((ReadMethod) other).balanceScope;
        } else {
            this.words = new ArrayList<>();
        }
    }

    State perform() throws IOException {
        char c = (char) file.read();
        if (c == '\n') {
            currentLine = new ArrayList<>();
            return new ReadMethod(this, this.nameOfMethod);
        } else {
            if (c == '{') {
                balanceScope += 1;
            }
            if (c == '}') {
                balanceScope -= 1;
            }
            if (!Character.isLetter(c)) {
                if (currentWord.length() != 0) {
                    words.add(currentWord);
                    currentLine.add(currentWord);
                }
                currentWord = "";
            } else {
                currentWord += c;
            }
            if (balanceScope != 0) return new ReadMethod(this, this.nameOfMethod);
        }
        return new AddMethod(this);
    }

    public ArrayList<String> getWords() {
        return this.words;
    }

    public String getNameOfMethod() {
        return this.nameOfMethod;
    }
}
