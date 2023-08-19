package com.example.password_generator_word_web.data;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

@Repository
public class WordRepositoryImpl implements WordRepository {

    @SneakyThrows
    public List<String> findAll() {
        return lines(Paths.get(WordRepository.class.getResource("/words_alpha.txt").toURI()).toFile().toPath())
                .collect(Collectors.toList());
    }

}