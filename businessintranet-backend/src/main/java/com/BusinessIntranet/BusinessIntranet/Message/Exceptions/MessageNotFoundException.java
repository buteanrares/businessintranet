package com.BusinessIntranet.BusinessIntranet.Message.Exceptions;

public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException(String message) {
        super(message);
    }
}
