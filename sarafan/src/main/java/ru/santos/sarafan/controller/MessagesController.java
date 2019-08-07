package ru.santos.sarafan.controller;

import org.springframework.web.bind.annotation.*;
import ru.santos.sarafan.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessagesController {
    private List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){{
        add(new HashMap<String, String>(){{put("id","1");put("text","First message");}});
        add(new HashMap<String, String>(){{put("id","2");put("text","Second message");}});
        add(new HashMap<String, String>(){{put("id","3");put("text","Third message");}});
    }};
    /*Вывод списка сообщений*/
    @GetMapping
    public List<Map<String,String>> list(){
        return messages;
    }

    /*Вывод сообщения*/
    @GetMapping("{id}")
    public Map<String,String> message(
            @PathVariable String id
    ){
        return getMessage(id);
    }

    /*Метод поиска сообщения*/
    private Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream().filter(messages -> messages.get("id").equals(id))
                .findFirst().orElseThrow(NotFoundException::new);
    }

    /*Сохранение сообщения*/
    @PostMapping
    public Map<String,String> saveMessage(@RequestBody Map<String,String> message){
        message.put("id",String.valueOf(messages.size()+1));
        messages.add(message);
        return message;
    }

    /*Обновление сообщения*/
    @PutMapping("{id}")
    public Map<String,String> updateMessage(@PathVariable String id,@RequestBody Map<String,String> message){
        Map<String,String> messageInDB = getMessage(id);
        messageInDB.putAll(message);
        messageInDB.put("id",id);
        return messageInDB;
    }
    /*удаление сообщения*/
    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id){
        Map<String,String> messageInDB = getMessage(id);

        messages.remove(messageInDB);
    }





}
