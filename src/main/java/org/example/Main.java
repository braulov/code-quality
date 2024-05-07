package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        CodeAnalyzer analyzer = new CodeAnalyzer(path);
        System.out.println(analyzer.getTop3());
        System.out.print(analyzer.getPercentNotCamelCaseMethods());
        System.out.println("% correct names");
    }
}