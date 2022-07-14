package ru.flawden.springcourse.Music;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music{

    public void init() {
        System.out.println("List of rock music being created...");
    }
    public void destroy() {
        System.out.println("Keeping the state of rock music, please wait...");
    }
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
