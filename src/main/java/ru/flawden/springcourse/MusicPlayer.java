package ru.flawden.springcourse;

import ru.flawden.springcourse.Music.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    private List<Music> music = new ArrayList<>();

    private String name;
    private int volume;

    public MusicPlayer(){}

//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

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
        music.forEach(music -> System.out.println("Playing: " + music.getSong()));
        System.out.println("Volume: " + volume + "%");
    }
}
