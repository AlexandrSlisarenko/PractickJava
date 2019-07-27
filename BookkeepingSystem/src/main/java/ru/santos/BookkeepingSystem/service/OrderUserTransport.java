package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.santos.BookkeepingSystem.ModelData.Card.BooksInOrderUser;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;

import java.util.HashMap;
import java.util.List;

public class OrderUserTransport {

    private Long idOrder;
    private int priceOrder;
    private List<Book> booksOrder;
    private List<String> booksIdInOrder;
    private HashMap<String,String> nameAndQuantityBook;


    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
    }

    public List<Book> getBooksOrder() {
        return booksOrder;
    }

    public void setBooksOrder(List<Book> booksOrder) {
        this.booksOrder = booksOrder;
    }

    public HashMap<String, String> getNameAndQuantityBook() {
        return nameAndQuantityBook;
    }

    public void setNameAndQuantityBook(HashMap<String, String> nameAndQuantityBook) {
        this.nameAndQuantityBook = nameAndQuantityBook;
    }

    public List<String> getBooksIdInOrder() {
        return booksIdInOrder;
    }

    public void setBooksIdInOrder(List<String> booksIdInOrder) {
        this.booksIdInOrder = booksIdInOrder;
    }
}
