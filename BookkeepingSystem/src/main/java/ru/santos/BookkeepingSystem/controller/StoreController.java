package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Genre;
import ru.santos.BookkeepingSystem.service.StoreService;

import java.util.Map;

@Controller
@RequestMapping("/store")
public class StoreController {
   @Autowired
    private StoreService storeService;

    @GetMapping
    public String greeting(Map<String, Object> model){
        Iterable<Book> books = storeService.getBookService().getBookAll();
        model.put("books", books);
        model.put("genres", Genre.values());
        model.put("interval", storeService.getManager().getPausa());
        return "store";
    }

    @GetMapping("/neworder")
    public String newOrder(){
       storeService.getManager().createNewOrder("Алгоритмы. Руководство по разработке","Стивен Скиен","123");
       return "redirect:/store";
    }

    @PostMapping("/addbook")
    public String addBookToDeliveryList(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "genre") Genre genre,
            @RequestParam(name = "quantity") String quantity,
            @RequestParam(name = "price") String price
    ){
        storeService.getManager().addBookToDelivery(title,author,genre.getName(),quantity,price);
        return "redirect:/store";
    }

    @PostMapping("/updatetimedelevery")
    public String updatetimedelevery(@RequestParam(name = "interval") String interval){
        storeService.getManager().setPausa(interval);
        return "redirect:/store";
    }

    @PostMapping("/editprice")
    public String editprice(
            @RequestParam(name = "price") String price,
            @RequestParam("id") Book book
    ){
        storeService.editPrice(book, price);
        return "redirect:/store";
    }


}
