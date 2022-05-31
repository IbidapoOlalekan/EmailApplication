package com.example.EmailApplication.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class Message {
    @Id
    private String id;
    private String receiver;
    private String sender;
    private boolean isRead;
    private LocalDateTime date;
    private String messageBody;
}
