package ru.flawden.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.flawden.springcourse.Music.Music;
import ru.flawden.springcourse.Music.MusicGenres;
import ru.flawden.springcourse.exception.BadGenreException;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MusicPlayer music = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer music1 = context.getBean("musicPlayer", MusicPlayer.class);
        music.setName("Lavash");
        music.playMusic();
        music1.playMusic();
        try {
            music.playMusicByGenre(MusicGenres.ROCK);
        } catch (BadGenreException e) {
            System.out.println(e.getMessage());
        }
        context.close();
    }
}
