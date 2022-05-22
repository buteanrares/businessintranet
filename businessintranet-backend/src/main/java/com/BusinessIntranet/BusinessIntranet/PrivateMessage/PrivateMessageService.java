package com.BusinessIntranet.BusinessIntranet.PrivateMessage;

import com.BusinessIntranet.BusinessIntranet.PrivateMessage.Exceptions.MessageNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateMessageService {
    public final PrivateMessageRepository privateMessageRepository;

    @Autowired
    public PrivateMessageService(PrivateMessageRepository privateMessageRepository) {
        this.privateMessageRepository = privateMessageRepository;
    }

    public PrivateMessage createPrivateMessage(PrivateMessage privateMessage) {
        return this.privateMessageRepository.save(privateMessage);
    }

    public List<PrivateMessage> findAllPrivateMessages() {
        return this.privateMessageRepository.findAll();
    }

    public PrivateMessage findPrivateMessageById(Long id) {
        return this.privateMessageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message with id " + id + " does not exist."));
    }

    public Iterable<PrivateMessage> findAllPrivateMessagesBySender(Employee sender) {
        return this.privateMessageRepository.findAllBySender(sender);
    }

    public Iterable<PrivateMessage> findAllPrivateMessagesByReceiver(Employee receiver) {
        return this.privateMessageRepository.findAllByReceiver(receiver);
    }

    public PrivateMessage updatePrivateMessage(PrivateMessage privateMessage){
        return this.privateMessageRepository.save(privateMessage);
    }

    public void deletePrivateMessage(Long id){this.privateMessageRepository.deleteById(id);}
}
