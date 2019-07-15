package ru.santos.BookkeepingSystem.ModelData.Order;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Book> books;

    public Order(int id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBoook(String title, String author, Genre genre, int count, int price){
        this.books.add(new Book(title,author,genre,count,price));
    }
}
