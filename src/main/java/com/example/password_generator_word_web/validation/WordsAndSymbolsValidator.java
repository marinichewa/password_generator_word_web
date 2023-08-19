package com.example.password_generator_word_web.validation;

import com.example.password_generator_word_web.web.dto.GenerateRules;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WordsAndSymbolsValidator implements ConstraintValidator<WordsAndSymbols, GenerateRules> {
    @Override
    public void initialize(WordsAndSymbols wordsAndSymbols) {
    }

    @Override
    public boolean isValid(
            GenerateRules rules, ConstraintValidatorContext context) {
        if (rules.getWordCount() == 1 && rules.getSpecial() != 0) {
            return false;
        } else return true;
    }
}