package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic;

import com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage.BoardMessage;

import javax.persistence.*;
import java.util.List;

@Entity
public class BoardTopic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String title;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<BoardMessage> boardMessages;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BoardMessage> getBoardMessages() {
        return boardMessages;
    }

    public void setBoardMessages(List<BoardMessage> boardMessages) {
        this.boardMessages = boardMessages;
    }
}
