package ru.santos.hellospring;

public class ClassicMusic implements Music{

    private ClassicMusic(){};

    public static ClassicMusic getClassicMusic(){
        return new ClassicMusic();
    }

    public String getSound() {
        return "Hungarian Rhapsody";
    }

    public void myInit(){
        System.out.println("Initialization....");
    }

    public void myDestr(){
        System.out.println("Destroy....");
    }
}
