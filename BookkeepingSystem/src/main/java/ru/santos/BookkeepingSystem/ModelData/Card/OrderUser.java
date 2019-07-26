package ru.santos.BookkeepingSystem.ModelData.Card;

import ru.santos.BookkeepingSystem.ModelData.User.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long customer;

    private Integer paid;

    private Integer price;

    //@OneToMany
   // private List<BooksInOrderUser> booksInOrderUserList;

    public Long getUser() {
        return customer;
    }

    public void setUser(Long user) {
        this.customer = user;
    }

    public Long getId() {
        return id;
    }

    /*public List<BooksInOrderUser> getBooksInOrderUserList() {
        return booksInOrderUserList;
    }

    public void setBooksInOrderUserList(List<BooksInOrderUser> booksInOrderUserList) {
        this.booksInOrderUserList = booksInOrderUserList;
    }
    */

    public Integer isPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
