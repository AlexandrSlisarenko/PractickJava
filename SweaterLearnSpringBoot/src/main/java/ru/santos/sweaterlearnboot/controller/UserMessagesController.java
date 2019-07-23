package ru.santos.sweaterlearnboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.santos.sweaterlearnboot.domain.Message;
import ru.santos.sweaterlearnboot.domain.User;
import ru.santos.sweaterlearnboot.repos.MessageRepo;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@Controller
public class UserMessagesController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/user-messages/{user}")
    public String userMessges(
            @RequestParam (required = false ) String messageId,
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model
    ) {
        Set<Message> messages = user.getMessages();
        if(!StringUtils.isEmpty(messageId)) {
            Message msg = messageRepo.findById(Long.parseLong(messageId));
            model.addAttribute("message", msg);
        }
        model.addAttribute("userChannel", user);
        model.addAttribute("messages", messages);
        model.addAttribute("subscriptionsCount", user.getSubscriptions().size());
        model.addAttribute("subscribersCount", user.getSubscriptions().size());
        model.addAttribute("isCurrentUser", currentUser.equals(user));
        model.addAttribute("isSubscriber", user.getSubscriptions().contains(currentUser));


        return "userMessages";
    }
    private void saveFile(@Valid Message message, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            message.setFile(resultFilename);
        }
    }

    @PostMapping("/user-messages/{user}")
    public String updateMessage(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            //@Valid Message message,
            @RequestParam(name = "messageId", required = false) String messageId,
            @RequestParam("text") String text,
            @RequestParam("tag") String tag,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        if(!StringUtils.isEmpty(messageId)) {
            Message msg = messageRepo.findById(Long.parseLong(messageId));

            if (msg.getAuthor().equals(currentUser)) {
                if (!StringUtils.isEmpty(text)) {
                    msg.setText(text);
                }

                if (!StringUtils.isEmpty(tag)) {
                    msg.setTag(tag);
                }

                saveFile(msg, file);

                messageRepo.save(msg);
            }
        }else{
            Message newMessage = new Message();
            newMessage.setAuthor(currentUser);
            newMessage.setTag(tag);
            newMessage.setText(text);
            saveFile(newMessage, file);
            messageRepo.save(newMessage);
        }
        return "redirect:/user-messages/" + user;
    }

}
