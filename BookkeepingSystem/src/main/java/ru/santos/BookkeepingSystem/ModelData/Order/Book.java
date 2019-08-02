package ru.santos.BookkeepingSystem.ModelData.Order;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private Genre genre;
    private int count;
    private int price;
    @Column(nullable = true, columnDefinition="Boolean default FALSE")
    private boolean delete;
    @Column(nullable = true)
    private Date dataFirstDelivery;

    public Book(){}

    public Book(String title, String author, Genre genre, int count, int price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        if (count > 0) this.count = count;
        if (price > 0) this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Date getDataFirstDelivery() {
        return dataFirstDelivery;
    }

    public void setDataFirstDelivery(Date dataFirstDelivery) {
        this.dataFirstDelivery = dataFirstDelivery;
    }
}
