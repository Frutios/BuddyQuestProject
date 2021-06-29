package com.quest.buddy.services;

public class MessageErrorException extends Exception{
    public MessageErrorException() {
        super();
    }

    public MessageErrorException(String s) {
        super(s);
    }
}
