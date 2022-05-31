package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.data.repositories.MailBoxRepository;
import com.example.EmailApplication.dtos.responses.MailBoxCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxServiceImpl implements MailBoxService{
    @Autowired
    private MailBoxRepository mailBoxRepository;

    private MessageService messageService;
    public MailBoxServiceImpl(MessageService messageService){
        this.messageService = messageService;
    }

    @Override
    public MailBoxCreationResponse openMail(MailBoxes mailBoxes) {
        for (MailBox mailBox : mailBoxes.getBoxes()){
            messageService.createMessageFolder(mailBox);
            mailBoxRepository.save(mailBox);
        }
        return null;
    }
}
