package com.example.password_generator_word_web.web;

import com.example.password_generator_word_web.service.GenerateWord;
import com.example.password_generator_word_web.web.dto.GenerateRules;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class WebController {
    @Autowired
    GenerateWord generateWord;

    @PostMapping
    public String generate(@RequestBody @Valid GenerateRules rules) {
        return generateWord.generate(rules.getLength(), rules.getWordCount(), rules.getSpecial(), rules.isNumeric(), rules.isToUpperFirst());
    }
}
