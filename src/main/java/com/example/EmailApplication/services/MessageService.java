package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.dtos.requests.MessageRequest;
import com.example.EmailApplication.dtos.responses.MessageResponse;

public interface MessageService {
    void createMessageFolder(MailBox mailBox);

    MessageResponse sendMessage(MessageRequest messageRequest, String emailAddress);
}
