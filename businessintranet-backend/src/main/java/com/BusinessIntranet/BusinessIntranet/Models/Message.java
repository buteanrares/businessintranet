package com.BusinessIntranet.BusinessIntranet.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne
    private Employee sender;

    @OneToOne
    private Employee receiver;

    private String content;

    private LocalDateTime timeSent;

    public Message() {

    }

    public Message(Employee sender, Employee receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timeSent = LocalDateTime.now();
    }

}
