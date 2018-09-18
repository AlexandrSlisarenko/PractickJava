package com.company;

public class Animal {

    private String name;
    private String color;
    private String breed;

    private int max_run;
    private int max_swim;
    private int max_breed;

    Animal(){

    }

    public String getName(){
        return  this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return  this.color;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    public   String getBreed(){
        return  this.breed;
    }

    public void printDescription(){
        System.out.print("Кличка: "+this.name);
        System.out.println();
        System.out.print("Цвет: "+this.color);
        System.out.println();
        System.out.print("Порода: "+this.breed);
        System.out.println();
    }

}
