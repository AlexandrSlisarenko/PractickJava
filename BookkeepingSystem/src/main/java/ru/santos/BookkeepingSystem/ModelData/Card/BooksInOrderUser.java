package ru.santos.BookkeepingSystem.ModelData.Card;

import ru.santos.BookkeepingSystem.ModelData.Order.Book;

import javax.persistence.*;

@Entity
public class BooksInOrderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderUserId;

    private Integer bookId;

    private Integer quantity;

    public Long getOrderUser() {
        return orderUserId;
    }

    public void setOrderUser(Long orderUser) {
        this.orderUserId = orderUser;
    }

    public Integer getBook() {
        return bookId;
    }

    public void setBook(Integer book) {
        this.bookId = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }
}
