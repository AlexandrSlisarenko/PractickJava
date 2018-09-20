package com.company;

public class Feeder {
    private final int volume;
    private int volume_feed_now;


    public Feeder(int v){
        this.volume = v;
        this.volume_feed_now = v;
    }

    public void checkEmpty(){
        if(this.volume_feed_now < this.volume / 2){
            System.out.println("Миска почи пуста, необходимо наполнить");
            this.volume_feed_now = this.volume;
            System.out.println("Миска наполнена");
        }
    }

    public void setVolumeFeed(int v_f_n){
        this.volume_feed_now = v_f_n;
    }
    public int getVolumeFeed(){
        return this.volume_feed_now;
    }
}
