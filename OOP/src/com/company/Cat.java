package com.company;

public class Cat extends Animal implements Moves {

    private int max_run;
    private int max_jamp;
    private boolean satiety;
    private int stomach;

    public Cat(String name, String color, String breed, int m_r, int max_j){
       this.setName(name);
       this.setColor(color);
       this.setBreed(breed);
       this.max_run = m_r;
       this.max_jamp = max_j;

    }
    public Cat(String name, String color, String breed, int m_r, int max_j, int stomach){
        this.setName(name);
        this.setColor(color);
        this.setBreed(breed);
        this.max_run = m_r;
        this.max_jamp = max_j;
        this.satiety  = false;
        this.stomach = stomach;
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

    public boolean getSatiety(){
        return this.satiety;
    }

    public void eat(Feeder f){
        if(this.stomach <= f.getVolumeFeed()){
            this.satiety = true;
            f.setVolumeFeed(f.getVolumeFeed() - this.stomach);
            System.out.println("Кот сыт, ура!!!!");
        }else{
            System.out.println("Мало корма, хозяин!!!!");
        }

    }
    public void printSatiety(){
        if(this.satiety) System.out.println("Сытый и довольный кот!!!");
        else System.out.println("Голодный и грусный кот!!!");
    }
}
