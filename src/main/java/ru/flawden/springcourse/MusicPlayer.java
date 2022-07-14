package ru.flawden.springcourse;

import ru.flawden.springcourse.Music.Music;

public class MusicPlayer {

    private Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
