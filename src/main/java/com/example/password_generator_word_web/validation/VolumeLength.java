package com.example.password_generator_word_web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VolumeLengthValidator.class)
public @interface VolumeLength {
    String message() default "Length of password is short for words count or numbers or symbols";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}