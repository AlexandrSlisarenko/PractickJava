package ru.santos.sweaterlearnboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.sweaterlearnboot.domain.Message;
import ru.santos.sweaterlearnboot.domain.User;
import ru.santos.sweaterlearnboot.repos.MessageRepo;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String,Object>model){
        //вывод сообщений
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String,Object> model){
        Message message = new Message(text,tag, user);
        messageRepo.save(message);

        //вывод сообщений
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String,Object> model){
        Iterable <Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
            System.out.println("да");
        }else {
            messages = messageRepo.findAll();
            System.out.println("Нет");
        }
        model.put("messages", messages);
        return  "main";
    }

}
