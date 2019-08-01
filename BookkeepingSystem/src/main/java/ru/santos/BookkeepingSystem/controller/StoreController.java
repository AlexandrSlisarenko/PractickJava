package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.queueManager.Manager;
import ru.santos.BookkeepingSystem.repos.BookRepo;

import java.util.Map;

@Controller
public class StoreController {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private Manager manager;

    @GetMapping("/store")
    public String greeting(Map<String, Object> model){
        Iterable<Book> books = bookRepo.findAll();
        model.put("books", books);
        return "store";
    }

    @GetMapping("/store/neworder")
    public String newOrder(){
       manager.createNewOrder("Алгоритмы. Руководство по разработке","Стивен Скиен","123");
       return "redirect:/store";
    }

}
