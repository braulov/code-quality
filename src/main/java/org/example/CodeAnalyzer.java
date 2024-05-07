package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CodeAnalyzer {
    private final String filepath;
    private final HashMap<String, Integer> methodsScore;
    private final HashMap<String, Boolean> namesCorrespondToCamelCase;

    CodeAnalyzer(String filepath) throws IOException {
        this.filepath = filepath;
        this.methodsScore = new HashMap<>();
        this.namesCorrespondToCamelCase = new HashMap<>();
        parseCode();
    }

    private int getScore(ArrayList<String> words) {
        int count = 0;
        ArrayList<String> conditionalStatements = new ArrayList<>(Arrays.asList("if", "switch", "for", "while", "else if", "else", "do"));
        for (String word : words) {
            if (conditionalStatements.contains(word)) count += 1;
        }
        return count;
    }

    boolean checkCamelCase(String nameOfMethod) {
        for (int i = 0; i < nameOfMethod.length(); i++) {
            if (!Character.isLetter(nameOfMethod.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void addMethod(String nameOfMethod, ArrayList<String> words) {
        methodsScore.put(nameOfMethod, getScore(words));
        namesCorrespondToCamelCase.put(nameOfMethod, checkCamelCase(nameOfMethod));
    }

    public void parseCode() throws IOException {
        FileReader file = new FileReader(filepath);
        State currentState = new Empty(file, this);
        while (!currentState.isClosed()) {
            currentState = currentState.perform();
        }
    }

    public HashMap<String, Integer> getTop3() {
        return methodsScore.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public int getPercentNotCamelCaseMethods() {
        int count = 0;
        for (boolean value : namesCorrespondToCamelCase.values()) {
            if (value) count++;
        }
        return (100 * count) / namesCorrespondToCamelCase.size();
    }

}
