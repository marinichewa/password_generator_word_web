package com.example.password_generator_word_web.service;

public interface PasswordGenerator {
    String generate(int length, int wordCount, char special, boolean numeric, boolean toUpperFirst);
}
