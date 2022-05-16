package com.BusinessIntranet.BusinessIntranet.SharedModels;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    @OneToOne
    private Employee sender;
    private String content;
    private LocalDateTime timeSent;


    public Message() {

    }

    public Message(Employee sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timeSent = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }
}
