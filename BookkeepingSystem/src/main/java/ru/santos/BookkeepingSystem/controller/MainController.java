package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.BookkeepingSystem.ModelData.Order.Author;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Genre;
import ru.santos.BookkeepingSystem.service.FiltrService;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private FiltrService filtrService;

    @GetMapping("/")
    public String welcome(Map<String, Object> model){
        Iterable<Book> books = filtrService.getBookRepo().findAll();
        Iterable<Author> authors = filtrService.getAuthorRepo().findAll();
        model.put("books", books);
        model.put("authors", authors);
        model.put("genres", Genre.values());
        model.put("path", "/");
        return "welcome";
    }

    @PostMapping("/")
    public  String filtr(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "genre") String genre,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "minP") String minP,
            @RequestParam(name = "maxP") String maxP,
            Map<String, Object> model
    ){
        ArrayList<Book> books = filtrService.filtr(name, author, genre, minP, maxP);
        Iterable<Author> authors = filtrService.getAuthorRepo().findAll();
        model.put("books", books);
        model.put("authors", authors);
        model.put("genres", Genre.values());
        model.put("path", "/");
        return "welcome";
    }



}
