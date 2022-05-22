package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic.Exceptions;

public class BoardTopicNotFoundException extends RuntimeException{
    public BoardTopicNotFoundException(String message) {
        super(message);
    }
}
