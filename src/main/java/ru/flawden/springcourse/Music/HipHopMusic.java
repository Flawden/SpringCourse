package ru.flawden.springcourse.Music;

import org.springframework.stereotype.Component;

@Component
public class HipHopMusic implements Music{

    public void init() {
        System.out.println("List of hip-hop music being created...");
    }
    public void destroy() {
        System.out.println("Keeping the state of hip-hop music, please wait...");
    }
    @Override
    public String getSong() {
        return "Make destroy";
    }
}
