package com.BusinessIntranet.BusinessIntranet.Models;

import javax.persistence.*;

@Entity(name="Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne
    private Account sender;

    @OneToOne
    private Account receiver;

    private String content;
}
