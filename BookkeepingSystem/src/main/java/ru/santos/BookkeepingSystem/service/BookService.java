package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Genre;
import ru.santos.BookkeepingSystem.repos.BookRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap<String, Integer> getListGenre() {
        HashMap<String, Integer> res = new HashMap<>();
        for (Genre g: Genre.values()) {
            res.put(g.getName(),0);
        }
        return res;
    }
}
