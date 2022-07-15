package ru.flawden.springcourse.Music;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class HipHopMusic implements Music{

    @Value("${musicList.hiphopMusic}")
    private String[] musics;

    public void init() {
        System.out.println("List of hip-hop music being created...");
    }
    public void destroy() {
        System.out.println("Keeping the state of hip-hop music, please wait...");
    }
    @Override
    public List<String> getSong() {
        return Arrays.asList(musics);
    }
}
