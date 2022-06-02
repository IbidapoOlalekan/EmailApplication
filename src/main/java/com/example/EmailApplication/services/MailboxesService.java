package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.data.models.Message;
import com.example.EmailApplication.dtos.responses.MailResponse;

import java.util.List;

public interface MailboxesService {
    MailBoxes createMailboxes(String email);

    void addMessage(Message message);

    MailResponse viewAllInboxes(String emailAddress);

    MailResponse viewAllSent(String emailAddress);
}
