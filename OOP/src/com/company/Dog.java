package com.company;

public class Dog extends Animal implements Moves {
    private int max_run;
    private int max_jamp;
    private int max_swim;

    public Dog(String name, String color, String breed, int m_r, int max_j, int max_s){
        this.setName(name);
        this.setColor(color);
        this.setBreed(breed);
        this.max_run = m_r;
        this.max_jamp = max_j;
        this.max_swim = max_s;

    }

    @Override
    public boolean run(int distancia) {
        return (distancia <= this.max_run)?true:false;
    }

    @Override
    public boolean swim(int distancia) {
        return (distancia <= this.max_swim)?true:false;
    }

    @Override
    public boolean jamp(int height) {
        return (height <= this.max_jamp)?true:false;
    }
}
