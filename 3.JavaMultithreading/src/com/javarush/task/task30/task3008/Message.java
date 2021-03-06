package com.javarush.task.task30.task3008;

import java.io.Serializable;

/**
 * Created by User on 14.06.2017.
 */
public class Message implements Serializable {

    private final MessageType type; //тип сообщения.
    private final String data;      // данные сообщения.

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }



    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }


}
