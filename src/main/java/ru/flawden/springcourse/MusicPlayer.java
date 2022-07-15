package ru.flawden.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.flawden.springcourse.Music.*;
import ru.flawden.springcourse.exception.BadGenreException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
public class MusicPlayer {

    private List<Music> music = new ArrayList<>();
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
    private HipHopMusic hipHopMusic;
    private Random rnd = new Random();

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public MusicPlayer(){}

    @Autowired
    public MusicPlayer(List<Music> music, ClassicalMusic classicalMusic, RockMusic rockMusic, HipHopMusic hipHopMusic) {
        this.music = music;
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.hipHopMusic = hipHopMusic;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
        System.out.println(name);
        music.forEach(music -> music.getSong().forEach(song -> System.out.println("Playing: " + song)));
        System.out.println("Volume: " + volume + "%");
    }

    public void playMusicByGenre(MusicGenres genre) throws BadGenreException {
        System.out.println(name);
        int n = 0;
        if (genre == MusicGenres.CLASSICAL) {
            int l = classicalMusic.getSong().size();
            System.out.println("Playing: " + classicalMusic.getSong().get(rnd.nextInt(l)));
        } else if (genre == MusicGenres.ROCK) {
            int l = rockMusic.getSong().size();
            System.out.println("Playing: " + rockMusic.getSong().get(rnd.nextInt(l)));
        } else if (genre == MusicGenres.HIPHOP) {
            int l = hipHopMusic.getSong().size();
            System.out.println("Playing: " + hipHopMusic.getSong().get(rnd.nextInt(l)));
        } else throw new BadGenreException("Error: non-existent genre of music");

        System.out.println("Volume: " + volume + "%");
    }

}
