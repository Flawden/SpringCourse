package ru.flawden.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.flawden.springcourse.Music.Music;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MusicPlayer music = context.getBean("MusicPlayer", MusicPlayer.class);
        music.playMusic();

        context.close();
    }
}
