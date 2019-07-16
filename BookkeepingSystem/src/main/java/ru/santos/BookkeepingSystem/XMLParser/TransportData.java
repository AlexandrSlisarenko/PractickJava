package ru.santos.BookkeepingSystem.XMLParser;

import org.springframework.stereotype.Component;
import ru.santos.BookkeepingSystem.ModelData.Order.Genre;
@Component
public class TransportData {
    private String title;
    private String author;
    private Genre genre;
    private int count;
    private int price;

    public TransportData() {
        this.title = "";
        this.author = "";
        this.count = 0;
        this.price = 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
            Genre[] massG = Genre.values();
            for (Genre g: massG)
            {
                if(g.getName() == genre);
                this.genre = g;
                break;
            }


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

    public void setCount(String count) {
        this.count = Integer.parseInt(count);
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }


    public boolean isFilled(){
        if(this.author!=""&&this.title!=""&&this.count!=0&&this.price!=0)
            return true;
        else
            return false;
    }

    public void clearTransport(){
        this.title = "";
        this.author = "";
        this.count = 0;
        this.price = 0;
    }
}
