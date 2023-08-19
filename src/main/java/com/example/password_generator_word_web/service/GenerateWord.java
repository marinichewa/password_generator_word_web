package com.example.password_generator_word_web.service;

import com.example.password_generator_word_web.data.WordRepositoryImpl;
import lombok.val;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@Service
public class GenerateWord implements PasswordGenerator {

    private static final String NUMBERS = "1234567890";
    WordRepositoryImpl wordRepository = new WordRepositoryImpl() ;

    @Override
    public String generate(int length, int wordCount, char special, boolean numeric, boolean toUpperFirst) {
        if ((!numeric) && (maxLength(wordCount, special) < length)) {
            return "In dictionary not found words with this length";
        } else {
            return generatePassword(length, wordCount, special, numeric, toUpperFirst);
        }
    }

    private String generatePassword(int length, int wordCount, char special, boolean numeric, boolean toUpperFirst) {
        StringBuilder result = new StringBuilder();
        int reserve = 0;
        if (numeric && special != 0) {
            reserve = nextInt(wordCount, length - wordCount * 3 + 1);
        }
        if (numeric && special == 0) {
            reserve = nextInt(1, length - wordCount * 3 + 1);
        }
        if (!numeric && special != 0) {
            reserve = wordCount - 1;
        }
        int newLength = length - reserve;
        while (wordCount > 1) {
            int freePlace = newLength - result.length();
            int wordLength = maxLengthOfDictionary();
            if (freePlace - (wordCount - 1) * 3 + 1 <= maxLengthOfDictionary()) {
                wordLength = nextInt(3, freePlace - (wordCount - 1) * 3 + 1);
            }
            result.append(toUpperFirst(toUpperFirst, randomWord(wordLength)));
            if (special != 0) {
                result.append(special);
                reserve--;
                newLength++;
            }
            wordCount--;
        }
        if ((newLength - result.length()) > maxLengthOfDictionary()) {
            return "In dictionary not found words with this length";
        } else {
            result.append(toUpperFirst(toUpperFirst, randomWord((newLength - result.length()))));
        }
        while (length > result.length()) {
            result.append(NUMBERS.charAt(nextInt(0, NUMBERS.length())));
        }
        return result.toString();
    }

    private String toUpperFirst(boolean toUpp, String word) {
        word = word.substring(0, 1).toLowerCase() + word.substring(1);
        if (!toUpp) {
            return word;
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }

    private String randomWord(int length) {
        val randomWord = wordRepository.findAll()
                .stream()
                .filter(s -> (s.length() == length && s.length() > 2))
                .toList();
        int numberWord = nextInt(0, randomWord.size());
        return randomWord.get(numberWord);
    }

    int maxLengthOfDictionary() {
        return wordRepository.findAll()
                .stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private int maxLength(int wordCount, char special) {
        if (special == 0) {
            return maxLengthOfDictionary() * wordCount;
        } else {
            return maxLengthOfDictionary() * wordCount + wordCount - 1;
        }
    }
}

