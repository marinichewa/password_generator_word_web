package com.example.password_generator_word_web.data;

import java.util.List;

public interface WordRepository {
    List<String> findAll();
}
