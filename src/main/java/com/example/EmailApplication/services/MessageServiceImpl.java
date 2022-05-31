package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.data.repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    private MessageRepository messageRepository;
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    @Override
    public void createMessageFolder(MailBox mailBox) {
        messageRepository.saveAll(mailBox.getMessages());
    }
}
