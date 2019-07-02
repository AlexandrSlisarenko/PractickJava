package ru.santos.sweaterlearnboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.santos.sweaterlearnboot.domain.Role;
import ru.santos.sweaterlearnboot.domain.User;
import ru.santos.sweaterlearnboot.repos.UserRepo;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if(userFromDB != null){
            model.put("message", "User exist");
            return "registration";
        }

        user.setActiv(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
