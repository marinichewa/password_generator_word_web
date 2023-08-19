package com.example.password_generator_word_web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WordsAndSymbolsValidator.class)
public @interface WordsAndSymbols {
    String message() default "Mast be minimum 2 words to split of symbols";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}