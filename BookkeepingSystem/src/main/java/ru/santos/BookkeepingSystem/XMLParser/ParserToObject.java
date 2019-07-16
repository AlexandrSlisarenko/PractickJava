package ru.santos.BookkeepingSystem.XMLParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Order;

import java.util.ArrayList;

@Component
public class ParserToObject {
    @Autowired
    private Order order;
    @Autowired
    private TransportData transportData;

    public ArrayList<Book> getListBook() {
        return this.order.getBooks();
    }

    private void fillingOrder(String key, String value) {
        switch (key) {
            case "title":
                this.transportData.setTitle(value);
                break;
            case "author":
                this.transportData.setAuthor(value);
                break;
            case "count":
                this.transportData.setCount(value);
                break;
            case "genre":
                this.transportData.setGenre(value);
                break;
            case "price":
                this.transportData.setPrice(value);
        }
    }

    private void addParam(String[] param) {
        fillingOrder(param[0], param[1]);
    }

    public void dataProcessing(String msg) {
        String[] order = msg.split("\\;\\@\\#\\$\\%");
        for (int i = 0; i < order.length; i++) {
            String[] book = order[i].split("\\;");
            for (int j = 0; j < book.length; j++) {
                addParam(book[j].split("\\="));
                if (this.transportData.isFilled()) {
                    this.order.addBoook(this.transportData.getTitle(), this.transportData.getAuthor()
                            , this.transportData.getGenre(), this.transportData.getCount(), this.transportData.getPrice());
                    this.transportData.clearTransport();
                }
            }
        }
    }

}
