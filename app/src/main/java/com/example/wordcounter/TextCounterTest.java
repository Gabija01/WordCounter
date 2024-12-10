package com.example.wordcounter;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class TextCounterTest {

    @Test
    public void testGetWordsCount() {
        TextCounter counter = new TextCounter();

        String text1 = "Hello world!";
        int result1 = counter.getWordsCount(text1);
        assertEquals(2, result1);

        String text2 = "";
        int result2 = counter.getWordsCount(text2);
        assertEquals(0, result2);

        String text3 = "    This   is    a   test    ";
        int result3 = counter.getWordsCount(text3);
        assertEquals(5, result3);
    }

    @Test
    public void testGetCharacterCount() {
        TextCounter counter = new TextCounter();

        String text1 = "Hello world!";
        int result1 = counter.getCharacterCount(text1);
        assertEquals(12, result1);

        String text2 = "";
        int result2 = counter.getCharacterCount(text2);
        assertEquals(0, result2);

        String text3 = "Hello world!";
        int result3 = counter.getCharacterCount(text3);
        assertEquals(12, result3);
    }
}
