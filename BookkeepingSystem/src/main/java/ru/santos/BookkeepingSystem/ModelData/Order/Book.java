package ru.santos.BookkeepingSystem.ModelData.Order;

public class Book {
    private String title;
    private String author;
    private Genre genre;
    private int count;
    private int price;

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
}
