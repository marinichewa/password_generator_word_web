package com.example.password_generator_word_web.validation;


import com.example.password_generator_word_web.web.dto.GenerateRules;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VolumeLengthValidator implements ConstraintValidator<VolumeLength, GenerateRules> {
    @Override
    public void initialize(VolumeLength fieldsValueValidate) {
    }

    @Override
    public boolean isValid(
            GenerateRules rules, ConstraintValidatorContext context) {
        if (!rules.isNumeric() && rules.getSpecial() == 0 && rules.getLength() / rules.getWordCount() < 3) {
            return false;
        }
        if (rules.isNumeric() && rules.getSpecial() == 0 && (rules.getLength() - 1) / rules.getWordCount() < 3) {
            return false;
        }
        if (!rules.isNumeric() && rules.getSpecial() != 0 && (rules.getLength() - rules.getWordCount() + 1) / rules.getWordCount() < 3) {
            return false;
        }
        if (rules.isNumeric() && rules.getSpecial() != 0 && (rules.getLength() - rules.getWordCount()) / rules.getWordCount() < 3) {
            return false;
        } else return true;

    }
}
