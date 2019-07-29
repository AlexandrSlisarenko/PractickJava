package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardUserService cardUserService;

    @PostMapping("/addBookToCard")
    public String addBookToCard(
            @RequestParam String quantity,
            @AuthenticationPrincipal User user,
            @RequestParam("bookId") Book book,
            HttpServletRequest request
    ){
        cardUserService.addToCard(book,user,Integer.parseInt(quantity));
        return "redirect:" + request.getHeader("referer");
    }

    @GetMapping
    public String showCard(
            @AuthenticationPrincipal User user,
            Model model
    ){
        OrderUserTransport transport = cardUserService.showOrderNotPaidUser(user);
        if(transport.getIdOrder() != null){
            model.addAttribute("order",transport);
            model.addAttribute("orderYES",1);
        }
        else model.addAttribute("orderYES",0);
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

    @GetMapping("/repeatorder")
    public String repeatorder(
            @RequestParam("id") OrderUser orderUser,
            Model model
    ){
        if(cardUserService.testCleanBasket(orderUser))
            return "redirect:/card";
        else return "redirect:/card/historyorders";
    }
    @GetMapping("/historyorders")
    public String historyorders(
            @AuthenticationPrincipal User user,
            Model model
    ){
        List<OrderUserTransport> history = cardUserService.getHistoryOrders(user.getId());
       if(history != null) model.addAttribute("history",history);
        else model.addAttribute("history",-1);
        return "historyOrders";
    }

}
