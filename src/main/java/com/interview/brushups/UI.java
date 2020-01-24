package com.interview.brushups;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.text.TextContentRenderer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Notes you want to Read?");
        System.out.println("____________________");
        System.out.println("1. Big Data");
        System.out.println("2. Hive Notes");
        System.out.println("3. SQL Notes");
        System.out.println("4. Java Notes");
        System.out.println("____________________");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                printFile("big-data-notes.md");
                break;
            case 2:
                printFile("hive-notes.md");
                break;
            case 3:
                printFile("sql-notes.md");
                break;
            case 4:
                printFile("java-notes.md");
                break;
        }
    }

    public static void printFile(String fileName) throws IOException {
        final String path = "src/main/java/com/interview/brushups/notes/"+fileName;
        String content = new String(Files.readAllBytes(Paths.get(path)));
        Parser parser = Parser.builder().build();
        Node document = parser.parse(content);
        TextContentRenderer renderer = TextContentRenderer.builder().build();
        System.out.println(renderer.render(document));
        main(null);
    }
}
