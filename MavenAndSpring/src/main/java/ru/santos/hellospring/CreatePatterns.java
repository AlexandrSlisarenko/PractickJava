package ru.santos.hellospring;

public class CreatePatterns {

    private static CreatePatterns instance;

    private CreatePatterns(){}

    public static CreatePatterns getInstance(){
        if(instance == null){
            instance = new CreatePatterns();
        }
        return instance;
    }

    public void info(){
        System.out.println("Hello Spring");
    }
}
