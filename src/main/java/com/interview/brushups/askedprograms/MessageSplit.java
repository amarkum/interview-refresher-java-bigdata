package com.interview.brushups.askedprograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Twilio - Split the message by 160 character, and also add the pagination
 */
public class MessageSplit {

    public static void main(String[] args) {

    String textMessage = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting," +
                " remaining essentially unchanged. " +
                " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        System.out.println(segments(textMessage));
    }

    static List<String> segments(String message) {
        List<String> messages = new ArrayList<>();
        final int splitLength = 154;
        if (message.length() < 160) {
            messages.add(message);
            return messages;
        }
        int start = 0, end = start + splitLength;
        while (end < message.length()) {
            if (message.charAt(end) != ' ') {
                while (end >= start && message.charAt(end) != ' ' && message.charAt(end + 1) != ' ') {
                    end--;
                }
            }
            messages.add(message.substring(start, end + 1));
            start = end + 1;
            end = start + splitLength;
        }
        messages.add(message.substring(start, message.length()));

        for (int j = 0; j < messages.size(); j++) {
            messages.set(j, messages.get(j) + "(" + (j + 1) + "/" + (messages.size()) + ")");
        }
        return messages;
    }
}
