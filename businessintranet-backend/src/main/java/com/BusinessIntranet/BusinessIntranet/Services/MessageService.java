package com.BusinessIntranet.BusinessIntranet.Services;

import com.BusinessIntranet.BusinessIntranet.Exceptions.MessageNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Models.Employee;
import com.BusinessIntranet.BusinessIntranet.Models.Message;
import com.BusinessIntranet.BusinessIntranet.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    public final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return this.messageRepository.save(message);
    }

    public List<Message> findAllMessages() {
        return this.messageRepository.findAll();
    }

    public Message findMessageById(Long id) {
        return this.messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message with id " + id + "does not exist."));
    }

    public Iterable<Message> findAllMessagesBySender(Employee sender) {
        return this.messageRepository.findAllBySender(sender);
    }

    public Iterable<Message> findAllMessagesByReceiver(Employee receiver) {
        return this.messageRepository.findAllByReceiver(receiver);
    }

    public Message updateMessage(Message message){return this.messageRepository.save(message);}

    public void deleteMessage(Long id){this.messageRepository.deleteById(id);}
}
