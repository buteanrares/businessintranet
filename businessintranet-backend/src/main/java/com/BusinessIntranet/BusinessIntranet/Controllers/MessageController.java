package com.BusinessIntranet.BusinessIntranet.Controllers;

import com.BusinessIntranet.BusinessIntranet.Models.Message;
import com.BusinessIntranet.BusinessIntranet.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messages = this.messageService.findAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") Long id){
        Message message = this.messageService.findMessageById(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        Message newMessage = this.messageService.createMessage(message);
        return new ResponseEntity<>(newMessage,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message){
        Message updateMessage = this.messageService.updateMessage(message);
        return new ResponseEntity<>(updateMessage,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id){
        this.messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
