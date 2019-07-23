package ru.santos.sweaterlearnboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.sweaterlearnboot.domain.User;
import ru.santos.sweaterlearnboot.service.UserService;

import javax.validation.Valid;
import java.util.Map;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user,
                          @RequestParam("password2") String passwordConfirm,
                          BindingResult bindingResult,
                          Model model) {
        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);
        if(isConfirmEmpty){
            model.addAttribute("password2Error", "Passwords do not match!");
        }
        if(user.getPassword() != null && user.getPassword().equals(passwordConfirm)){
            model.addAttribute("message","Passwords are different!");

        }
        if(isConfirmEmpty || bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exist");
            return "registration";
        }
        return "redirect:/login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            model.addAttribute("messageType","success");
            model.addAttribute("message","User is active!!!");
        }else {
            model.addAttribute("messageType","danger");
            model.addAttribute("message", "Activation code is not found");
        }
        return "login";
    }
}
