package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.repos.AuthorRepo;
import ru.santos.BookkeepingSystem.repos.BookRepo;

import java.util.ArrayList;

@Service
public class FiltrService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    private ArrayList<Book> result = new ArrayList<>();

    public BookRepo getBookRepo() {
        return bookRepo;
    }

    public AuthorRepo getAuthorRepo() {
        return authorRepo;
    }

    public ArrayList<Book> filtr(String name, String author, String genre, String minP, String maxP) {

        if(name != ""){
            filtrToName(bookRepo.findAll(), name);
        }
        if(author != ""){
            if(result.size() == 0) filtrToAuthor(bookRepo.findAll(), author);
            else filtrToAuthor(result, author);
        }
        if(genre != ""){
            if(result.size() == 0) filtrToGenre(bookRepo.findAll(), genre);
            else filtrToGenre(result, author);
        }
        if(minP != "" && maxP!= ""){
            if(result.size() == 0) filtrToPrice(bookRepo.findAll(), minP, maxP);
            else filtrToPrice(result, minP, maxP);
        }
        return  result;
    }

    private void filtrToPrice(Iterable<Book> all, String minP, String maxP) {
        Iterable<Book> tmp = all;
        result.clear();
        int min;
        int max;
        if(minP == "") min = 0;
        else min = Integer.parseInt(minP);
        if(maxP == "") max = 10000;
        else max = Integer.parseInt(maxP);
        for (Book book: tmp) {
            if(min < book.getPrice() && book.getPrice() < max) result.add(book);
        }
    }

    private void filtrToGenre(Iterable<Book> all, String genre) {
        Iterable<Book> tmp = all;
        result.clear();
        for (Book book: tmp) {
            if(book.getGenre().getName().contains(genre)) result.add(book);
        }
    }

    private void filtrToAuthor(Iterable<Book> all, String author) {
        Iterable<Book> tmp = all;
        result.clear();
        for (Book book: all) {
            if(book.getAuthor().contains(author)) result.add(book);
        }
    }

    private void filtrToName(Iterable<Book> all, String name) {
        Iterable<Book> tmp = all;
        result.clear();
        for (Book book: all) {
            if(book.getTitle().toLowerCase().contains(name.toLowerCase())) result.add(book);
        }
    }
}
