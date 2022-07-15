package ru.flawden.springcourse.Music;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {

    @Value("${musicList.classicalMusic}")
    private String[] musics;

    @Override
    public List<String> getSong() {
        return Arrays.asList(musics);
    }
}
