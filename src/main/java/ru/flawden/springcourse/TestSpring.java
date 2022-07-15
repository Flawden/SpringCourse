package ru.flawden.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.flawden.springcourse.Music.Music;
import ru.flawden.springcourse.Music.MusicGenres;
import ru.flawden.springcourse.config.SpringConfig;
import ru.flawden.springcourse.exception.BadGenreException;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer music = context.getBean("musicPlayer", MusicPlayer.class);
        music.playMusic();
        try {
            music.playMusicByGenre(MusicGenres.ROCK);
        } catch (BadGenreException e) {
            System.out.println(e.getMessage());
        }
        context.close();
    }
}
