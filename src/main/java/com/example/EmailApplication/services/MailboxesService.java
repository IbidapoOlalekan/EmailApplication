package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.data.models.Message;

public interface MailboxesService {
    MailBoxes createMailboxes(String email);

    void addMessage(Message message);
}
