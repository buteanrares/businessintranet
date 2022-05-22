package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic;

import com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage.BoardMessage;

import javax.persistence.*;
import java.util.List;

@Entity(name = "BoardTopic")
public class BoardTopic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String title;
    @OneToMany
    private List<BoardMessage> boardMessages;
    @OneToMany
    private List<BoardTopic> childBoardTopics;
}
