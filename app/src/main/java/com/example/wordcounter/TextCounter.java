package com.example.wordcounter;

public class TextCounter {

    public int getWordsCount(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("[\\s,.]+");
        return words.length;
    }

    public int getCharacterCount(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return text.length();
    }
}
