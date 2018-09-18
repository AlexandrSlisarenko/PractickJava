package com.company;

public class Cat extends Animal implements Moves {

    private int max_run;
    private int max_jamp;

    public Cat(String name, String color, String breed, int m_r, int max_j){
       this.setName(name);
       this.setColor(color);
       this.setBreed(breed);
       this.max_run = m_r;
       this.max_jamp = max_j;

    }

    @Override
    public boolean run(int distancia) {
        return (distancia <= this.max_run)?true:false;
    }

    @Override
    public boolean swim(int distancia) {
        return  false;
    }

    @Override
    public boolean jamp(int height) {
        return (height <= this.max_jamp)?true:false;
    }
}
