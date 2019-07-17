package ru.santos.BookkeepingSystem.ModelData.Order;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
@Component
public class Order {

    private ArrayList<Book> books;

    public Order() {
       this.books = new ArrayList<>();
    }



    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBoook(String title, String author, Genre genre, int count, int price){
        this.books.add(new Book(title,author,genre,count,price));
    }
}
