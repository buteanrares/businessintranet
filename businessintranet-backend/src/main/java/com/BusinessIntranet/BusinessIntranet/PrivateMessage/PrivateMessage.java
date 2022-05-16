package com.BusinessIntranet.BusinessIntranet.PrivateMessage;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.SharedModels.Message;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Messages")
public class PrivateMessage extends Message {

    @OneToOne
    private Employee receiver;

    private String content;

    private LocalDateTime timeSent;

    public PrivateMessage() {
    }

    public PrivateMessage(Employee sender, Employee receiver, String content) {
        super(sender,content);
        this.receiver = receiver;
    }

}
