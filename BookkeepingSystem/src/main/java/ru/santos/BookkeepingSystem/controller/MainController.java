package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.repos.BookRepo;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/")
    public String welcome(Map<String, Object> model){ return "welcome";}


    @GetMapping("/store")
    public String greeting(Map<String, Object> model){
        Iterable<Book> books = bookRepo.findAll();
        model.put("books", books);
        return "store";
    }

}
