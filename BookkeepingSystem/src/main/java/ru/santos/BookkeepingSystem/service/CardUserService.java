package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Card.BooksInOrderUser;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.User.User;
import ru.santos.BookkeepingSystem.repos.BookRepo;
import ru.santos.BookkeepingSystem.repos.Card.BooksInOrderUserRepo;
import ru.santos.BookkeepingSystem.repos.Card.OrderUserRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class CardUserService {
    @Autowired
    private OrderUserRepo orderUserRepo;

    @Autowired
    private BooksInOrderUserRepo booksInOrderUserRepo;

    @Autowired
    private BookRepo bookRepo;

    public void addToCard(Book book, User user, int quantity){
        boolean old = true;
        OrderUser orderUserNotPaid = orderUserRepo.findByCustomerAndPaid(user.getId(),0);
        if(orderUserNotPaid == null){
            orderUserNotPaid = new OrderUser();
            orderUserNotPaid.setUser(user.getId());
            orderUserNotPaid.setPaid(0);
            orderUserNotPaid.setPrice(book.getPrice() * quantity);
            orderUserRepo.save(orderUserNotPaid);
            old = false;
        }

        BooksInOrderUser booksInOrderUserExists = booksInOrderUserRepo.findByOrderUserIdAndBookId(orderUserNotPaid.getId(),book.getId());

        if(booksInOrderUserExists != null){
            booksInOrderUserExists.setQuantity(booksInOrderUserExists.getQuantity()+quantity);
            booksInOrderUserRepo.save(booksInOrderUserExists);
            orderUserNotPaid.setPrice((book.getPrice() * quantity)+orderUserNotPaid.getPrice());
            orderUserRepo.save(orderUserNotPaid);
        }else {
            booksInOrderUserExists = new BooksInOrderUser();
            booksInOrderUserExists.setQuantity(quantity);
            booksInOrderUserExists.setBook(book.getId());
            booksInOrderUserExists.setOrderUser(orderUserNotPaid.getId());
            booksInOrderUserRepo.save(booksInOrderUserExists);
            if(old){
                orderUserNotPaid.setPrice((book.getPrice() * quantity)+orderUserNotPaid.getPrice());
                orderUserRepo.save(orderUserNotPaid);
            }
        }


    }

    public OrderUserTransport showOrderNotPaidUser(User user){
        OrderUserTransport transport = new OrderUserTransport();
        OrderUser orderUserNotPaid = orderUserRepo.findByCustomerAndPaid(user.getId(),0);
        if(orderUserNotPaid != null){
            transport.setIdOrder(orderUserNotPaid.getId());
            transport.setPriceOrder(orderUserNotPaid.getPrice());
            transport.setNameAndQuantityBook(getTitleAndCountBook(booksInOrderUserRepo.findByOrderUserId(orderUserNotPaid.getId())));
            transport.setBooksOrder(getBooksOrder(booksInOrderUserRepo.findByOrderUserId(orderUserNotPaid.getId())));;
        }
        return  transport;
    }


    private HashMap<String,String> getTitleAndCountBook(List<BooksInOrderUser> booksInOrderUsers) {
        HashMap<String,String> res = new HashMap<>();
        for (BooksInOrderUser book: booksInOrderUsers) {
            String title = bookRepo.findById(book.getBook()).get().getTitle();
            res.put(title,book.getQuantity().toString());

        }
        return res;
    }

    private List<Book> getBooksOrder(List<BooksInOrderUser> booksInOrderUsers){
       List<Book> books = new ArrayList<>();
        for (BooksInOrderUser book: booksInOrderUsers) {
            books.add(bookRepo.findById(book.getBook()).get());
        }
        return books;
    }

}
