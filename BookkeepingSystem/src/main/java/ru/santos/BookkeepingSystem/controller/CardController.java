package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.User.User;
import ru.santos.BookkeepingSystem.service.CardUserService;
import ru.santos.BookkeepingSystem.service.OrderUserTransport;

import javax.validation.Valid;

@Controller
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

    @GetMapping("/card")
    public String showCard(
            @AuthenticationPrincipal User user,
            Model model
    ){
        OrderUserTransport transport = cardUserService.showOrderNotPaidUser(user);
        model.addAttribute("order",transport);
        return "card";
    }
}
