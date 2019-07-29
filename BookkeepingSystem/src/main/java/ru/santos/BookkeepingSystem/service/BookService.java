package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.repos.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book findBookById(Integer book) {
        return bookRepo.findById(book).get();
    }

    public void saveBook(Book book){
        bookRepo.save(book);
    }
}
