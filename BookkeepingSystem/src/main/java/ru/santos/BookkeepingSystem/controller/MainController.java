package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.santos.BookkeepingSystem.ModelData.Order.Author;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Genre;
import ru.santos.BookkeepingSystem.repos.AuthorRepo;
import ru.santos.BookkeepingSystem.repos.BookRepo;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping("/")
    public String welcome(Map<String, Object> model){
        Iterable<Book> books = bookRepo.findAll();
        Iterable<Author> authors = authorRepo.findAll();
        model.put("books", books);
        model.put("authors", authors);
        model.put("genres", Genre.values());
        model.put("path", "/");
        return "welcome";
    }



}
