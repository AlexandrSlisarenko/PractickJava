package ru.santos.BookkeepingSystem.ModelData.Order;

public enum Genre {
    TECHNICAL("технический");

    private String name;

    Genre(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
