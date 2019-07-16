package ru.santos.BookkeepingSystem.ModelData.Order;

import org.springframework.stereotype.Component;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.util.ArrayList;
@Component
//@Entity
public class Order {
  //  @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private ArrayList<Book> books;

    public Order() {
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
