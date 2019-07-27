package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.BookkeepingSystem.ModelData.Card.BooksInOrderUser;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.User.User;
import ru.santos.BookkeepingSystem.repos.Card.OrderUserRepo;
import ru.santos.BookkeepingSystem.service.CardUserService;
import ru.santos.BookkeepingSystem.service.OrderUserTransport;

import javax.validation.Valid;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardUserService cardUserService;

    @PostMapping("/addBookToCard")
    public String addBookToCard(
            @RequestParam String quantity,
            @AuthenticationPrincipal User user,
            @RequestParam("bookId") Book book
    ){
        cardUserService.addToCard(book,user,Integer.parseInt(quantity));
        return "redirect:/";
    }

    @GetMapping
    public String showCard(
            @AuthenticationPrincipal User user,
            Model model
    ){
        OrderUserTransport transport = cardUserService.showOrderNotPaidUser(user);
        if(transport.getIdOrder() != null) model.addAttribute("order",transport);
        else model.addAttribute("order",-1);
        return "card";
    }

    @PostMapping("/editcount")
    public  String edintCount(
            @RequestParam String quantity,
            @RequestParam("idBookInorder") BooksInOrderUser book
    ){
        cardUserService.editCountBookInOrder(book, quantity);
        return "redirect:/card";
    }

    @GetMapping("/delbook")
    public String deletBookOfOrder(
            @RequestParam("id") BooksInOrderUser book
    ){
        cardUserService.deletBookOfOrder(book);
        return "redirect:/card";
    }

    @GetMapping("/сheckout")
    public String сheckoutOrder(
            @RequestParam("orderId") OrderUser order,
            @AuthenticationPrincipal User user
    ){
        cardUserService.сheckoutOrder(order,user);
        return "redirect:/card";
    }

}
