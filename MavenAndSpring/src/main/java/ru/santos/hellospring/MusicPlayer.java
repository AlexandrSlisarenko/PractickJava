package ru.santos.hellospring;

import java.util.List;

public class MusicPlayer {
    private List<Music> music;
    private String name;
    private int volume;


    public MusicPlayer(List<Music> music){
        this.music = music;
    }
    public  MusicPlayer(){}

    public void setMusic(List<Music> music){
        this.music = music;
    }

    public void play(){
        for (int i = 0; i < this.music.size(); i++) {
            System.out.println("Plaing: " + this.music.get(i).getSound());
        }

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
