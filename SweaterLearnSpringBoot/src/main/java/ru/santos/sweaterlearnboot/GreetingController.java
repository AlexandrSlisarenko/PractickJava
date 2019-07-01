package ru.santos.sweaterlearnboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.santos.sweaterlearnboot.domain.Message;
import ru.santos.sweaterlearnboot.repos.MessageRepo;

import java.util.Iterator;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue = "HelloSpringBoot") String name,
                           Map<String, Object> model){
        model.put("name",name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String,Object>model){
        //приветствие
        model.put("some","Santos!!!");

        //вывод сообщений
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String,Object> model){
        model.put("some","Santos!!!");

        Message message = new Message(text,tag);
        messageRepo.save(message);

        //вывод сообщений
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filtr")
    public String filtr(@RequestParam String tag, Map<String,Object> model){
        model.put("some","Santos!!!");
        Iterable<Message> messages;
        if(tag != null && tag.isEmpty()) {
            messages = messageRepo.findByTag(tag);
        }else {
            messages = messageRepo.findAll();
        }
        model.put("messages",messages);
        return  "main";
    }

}
