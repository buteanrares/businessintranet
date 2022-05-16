package com.BusinessIntranet.BusinessIntranet.PrivateMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/message")
public class PrivateMessageController {
    private final PrivateMessageService privateMessageService;

    @Autowired
    public PrivateMessageController(PrivateMessageService privateMessageService) {
        this.privateMessageService = privateMessageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PrivateMessage>> getAllMessages(){
        List<PrivateMessage> privateMessages = this.privateMessageService.findAllPrivateMessages();
        return new ResponseEntity<>(privateMessages, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PrivateMessage> getMessage(@PathVariable("id") Long id){
        PrivateMessage privateMessage = this.privateMessageService.findPrivateMessageById(id);
        return new ResponseEntity<>(privateMessage,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PrivateMessage> createMessage(@RequestBody PrivateMessage privateMessage){
        PrivateMessage newPrivateMessage = this.privateMessageService.createPrivateMessage(privateMessage);
        return new ResponseEntity<>(newPrivateMessage,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PrivateMessage> updateMessage(@RequestBody PrivateMessage privateMessage){
        PrivateMessage updatePrivateMessage = this.privateMessageService.updatePrivateMessage(privateMessage);
        return new ResponseEntity<>(updatePrivateMessage,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id){
        this.privateMessageService.deletePrivateMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
