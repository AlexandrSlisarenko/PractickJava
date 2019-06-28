package ru.santos.hellospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AplicationContext.xml");

        //Music music = context.getBean("musicBean",Music.class);
        //MusicPlayer player = new MusicPlayer(music);
        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println("PlayerName: " + player.getName());
        System.out.println("Volume: " + player.getVolume());
        player.play();
        MusicPlayer player1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer player2 = context.getBean("musicPlayer", MusicPlayer.class);
        player1.setName("Мафон1");
        player1.setVolume(12);
        System.out.println("PlayerName: " + player1.getName());
        System.out.println("Volume: " + player1.getVolume());

        player2.setName("Мафон2");
        player2.setVolume(300);
        System.out.println("PlayerName: " + player2.getName());
        System.out.println("Volume: " + player2.getVolume());

        ClassicMusic cm = context.getBean("musicClassic", ClassicMusic.class);

        cm.getSound();


        context.close();
    }
}
