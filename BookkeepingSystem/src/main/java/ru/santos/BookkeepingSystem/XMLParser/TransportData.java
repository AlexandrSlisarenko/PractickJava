package ru.santos.BookkeepingSystem.XMLParser;

import ru.santos.BookkeepingSystem.ModelData.Order.Genre;

public class TransportData {
    private String title;
    private String author;
    private Genre genre;
    private int count;
    private int price;



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

    public void setCount(String count) {
        this.count = Integer.parseInt(count);
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }
}
