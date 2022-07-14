package ru.flawden.springcourse;

import ru.flawden.springcourse.Music.Music;

public class MusicPlayer {

    private Music music;

    private String name;
    private int volume;

    public MusicPlayer(){}

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
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
        System.out.println(name + "\n" +
                "Playing: " + music.getSong() + "\n" +
                "Volume: " + volume + "%");
    }
}
