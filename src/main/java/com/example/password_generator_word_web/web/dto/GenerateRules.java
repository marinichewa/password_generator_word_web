package com.example.password_generator_word_web.web.dto;

import com.example.password_generator_word_web.validation.VolumeLength;
import com.example.password_generator_word_web.validation.WordsAndSymbols;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@VolumeLength
@WordsAndSymbols
public class GenerateRules {
    @Min(value = 3, message = "Minimal length must be 3")
    @NotNull(message = "Entry length password")
    private int length;

    @Min(value = 1, message = "Minimal count of word must be 1")
    private int wordCount = 1;
    private char special = 0;
    private boolean numeric;
    private boolean toUpperFirst;
}
