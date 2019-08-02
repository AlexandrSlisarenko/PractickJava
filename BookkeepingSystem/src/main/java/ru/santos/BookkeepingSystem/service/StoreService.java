package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.queueManager.Manager;

@Service
public class StoreService {
    @Autowired
    private Manager manager;

    @Autowired
    private BookService bookService;

    public String getTimeDelivery(){
        return manager.getPausa();
    }

    public void setTimeDelivery(String time){
        manager.setPausa(time);
    }

    public BookService getBookService() {
        return bookService;
    }

    public Manager getManager() {
        return manager;
    }

    public void editPrice(Book book, String price) {
        book.setPrice(Integer.parseInt(price));
        bookService.saveBook(book);
    }
}
