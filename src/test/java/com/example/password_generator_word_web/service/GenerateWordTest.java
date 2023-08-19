package com.example.password_generator_word_web.service;

import com.example.password_generator_word_web.service.GenerateWord;
import org.junit.jupiter.api.Test;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateWordTest {

    @Test
    void testGenerateNotDictionary() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(word.maxLengthOfDictionary() + 1, 1, special, false, true);
        assertEquals("In dictionary not found words with this length", password);
    }

    @Test
    void testGenerateNotDictionaryTwoWordsSpecial() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(word.maxLengthOfDictionary() * 2 + 2, 2, '_', false, true);
        assertEquals("In dictionary not found words with this length", password);
    }

    @Test
    void testGenerateNotDictionaryTwoWords() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(word.maxLengthOfDictionary() * 2 + 1, 2, special, false, true);
        assertEquals("In dictionary not found words with this length", password);
    }

    @Test
    void testGenerateIsDictionary() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(word.maxLengthOfDictionary(), 1, special, false, true);
        assertEquals(false, password.equals("In dictionary not found words with this length"));
    }

    @Test
    void testGenerateIsDictionaryTwoWords() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(word.maxLengthOfDictionary() * 2, 2, special, false, true);
        assertEquals(false, password.equals("In dictionary not found words with this length"));
    }

    @Test
    void testGenerateIsDictionaryTwoWordsSpecial() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(word.maxLengthOfDictionary() * 2 + 1, 2, '_', false, true);
        assertEquals(false, password.equals("In dictionary not found words with this length"));
    }

    @Test
    void testGenerateLength() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(10, 1, '_', false, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthTwoWords() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(10, 2, special, false, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthSpecial() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(10, 2, 'p', false, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthSpecialNum() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(10, 1, 'p', true, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthNum() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(10, 2, '0', true, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthAll() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(10, 2, '_', true, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthMaxValue() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(9, 3, special, false, true);
        assertEquals(9, password.length());
    }

    @Test
    void testGenerateLengthMaxValueNum() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(10, 3, special, true, true);
        assertEquals(10, password.length());
    }

    @Test
    void testGenerateLengthMaxValueSpecial() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(11, 3, '_', false, true);
        assertEquals(11, password.length());
    }

    @Test
    void testGenerateLengthMaxValueAll() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(12, 3, '_', true, true);
        assertEquals(12, password.length());
    }


    @Test
    void testToUpperFirstTrue() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(12, 1, '_', true, true);
        assertEquals(true, isUpperCase(password.charAt(0)));
    }

    @Test
    void testToUpperFirstFalse() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(12, 1, '_', true, false);
        assertEquals(true, isLowerCase(password.charAt(0)));
    }

    @Test
    void testToUpperFirstTrueTwoWords() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(6, 2, special, false, true);
        assertEquals(true, isUpperCase(password.charAt(0)) & isUpperCase(password.charAt(3)));
    }

    @Test
    void testToUpperFirstFalseTwoWords() {
        GenerateWord word = new GenerateWord();
        char special = 0;
        String password = word.generate(6, 2, special, false, false);
        assertEquals(true, isLowerCase(password.charAt(0)) & isLowerCase(password.charAt(3)));
    }

    @Test
    void testToUpperFirstFalseTwoWordsSpecial() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(7, 2, '_', false, false);
        assertEquals(true, isLowerCase(password.charAt(0)) & isLowerCase(password.charAt(4)));
    }

    @Test
    void testToUpperFirstTrueTwoWordsSpecial() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(7, 2, '_', false, true);
        assertEquals(true, isUpperCase(password.charAt(0)) & isUpperCase(password.charAt(4)));
    }

    @Test
    void testSpecialCount() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(20, 5, '_', false, true);
        int specialcount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == '_') {
                specialcount++;
            }
        }
        assertEquals(4, specialcount);
    }

    @Test
    void testNumericTrue() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(20, 5, '_', true, true);
        assertEquals(true, password.matches("(.[^0-9]*\\d*)"));
    }

    @Test
    void testNumericFalse() {
        GenerateWord word = new GenerateWord();
        String password = word.generate(20, 5, '_', false, false);
        assertEquals(true, password.matches("(.[^0-9]*)"));
    }
}