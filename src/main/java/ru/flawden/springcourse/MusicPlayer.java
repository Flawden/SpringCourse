package ru.flawden.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.flawden.springcourse.Music.Music;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class MusicPlayer {

    private List<Music> music = new ArrayList<>();

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public MusicPlayer(){}

    @Autowired
    public MusicPlayer(List<Music> music) {
        this.music = music;
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
        music.forEach(music -> System.out.println("Playing: " + music.getSong()));
        System.out.println("Volume: " + volume + "%");
    }
}
