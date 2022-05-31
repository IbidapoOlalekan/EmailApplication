package com.example.EmailApplication.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class MailBox {
    @Id
    private String userName;
    private Type mailType;
    private List<Message> messages;

    public MailBox(Type mailType, List<Message> messageList){
        this.mailType = mailType;
        this.messages = messageList;
    }
}
