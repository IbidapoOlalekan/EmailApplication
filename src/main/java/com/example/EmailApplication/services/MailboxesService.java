package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.data.models.Message;

import java.util.List;

public interface MailboxesService {
    MailBoxes createMailboxes(String email);

    void addMessage(Message message);

    List<MailBox> viewAllInboxes(String emailAddress);

    List<MailBox> viewAllSent(String emailAddress);
}
