package ru.santos.BookkeepingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.User.Role;
import ru.santos.BookkeepingSystem.ModelData.User.User;
import ru.santos.BookkeepingSystem.service.UserService;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String,String> form,
            @RequestParam("userId") User user) {
        userService.saveUser(username,form, user);

        return "redirect:/user";
    }


    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("username", user.getUsername()   );
        model.addAttribute("many", user.getMany());
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @RequestParam String email,
            @RequestParam String password,
            @AuthenticationPrincipal User user
    ){
        userService.updateProfile(email, password, user);
        return "redirect:/user/profile";
    }

    @GetMapping("likedList")
    public String likedView(Model model, @AuthenticationPrincipal User user){
        ArrayList<Book> likesBooks = userService.getLikedBooks(user.getId());
        model.addAttribute("books", likesBooks);
        model.addAttribute("addDel",false);
        return "liked";
    }
    @GetMapping("liked")
    public String likedBookAdd(
            @AuthenticationPrincipal User user,
            @RequestParam (required = false ) Integer bookId
            ){

        userService.saveLikedBook(bookId, user.getId());
        return "redirect:/";
    }
    @GetMapping("delliked")
    public String dellikedBookAdd(
            @AuthenticationPrincipal User user,
            @RequestParam (required = false ) Integer bookId
            ){
        userService.deleteLikedBook(bookId, user.getId());
        return "redirect:/user/likedList";
    }



}
