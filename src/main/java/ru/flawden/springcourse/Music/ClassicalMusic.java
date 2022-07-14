package ru.flawden.springcourse.Music;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    public void init() {
        System.out.println("List of classical music being created...");
    }
    public void destroy() {
        System.out.println("Keeping the state of classical music, please wait...");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
