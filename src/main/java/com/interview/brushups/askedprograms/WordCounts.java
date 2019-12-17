package com.interview.brushups.askedprograms;

import java.io.*;

public class WordCounts {

    public static void main(String[] args) throws IOException {
        String[] words;
        int wordCount = 0;
        //Create a File Object,to read the file from System.
        File file = new File("word-count.txt");
        //Create a FileReader Object by inputting file name.
        FileReader fileReader = new FileReader(file);
        // Create a BufferReader object by passing the file.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            words = line.split(" ");
            wordCount = wordCount + words.length;
        }
        System.out.println(wordCount);
    }
}
