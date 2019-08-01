package ru.santos.BookkeepingSystem.ModelData.Order;

public enum Genre {
    TECHNICAL("технический"),JAVA("Java"),SPRING("Spring"),JSON_REST_HTTP("http/Рест/JSON"),FRONTEND("FrontEnd");

    private String name;

    Genre(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
