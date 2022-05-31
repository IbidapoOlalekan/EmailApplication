package com.example.EmailApplication.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class MailBoxes {
    @Id
    private String username;

    private List<MailBox> boxes;

    public MailBoxes(String username){
        this.username = username;
        if (boxes == null){
            boxes = new ArrayList<>();
        }
        this.boxes = boxes;
        boxes.add(new MailBox(Type.INBOX,new ArrayList<>()));
        boxes.add(new MailBox(Type.SENT,new ArrayList<>()));
    }

}
