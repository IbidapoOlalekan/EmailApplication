package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.data.models.Message;
import com.example.EmailApplication.data.repositories.MailBoxesRepository;
import org.springframework.stereotype.Service;

@Service
public class MailboxesServiceImpl implements MailboxesService{
    private MailBoxesRepository mailBoxesRepository;
    public MailboxesServiceImpl(MailBoxesRepository mailBoxesRepository){
        this.mailBoxesRepository = mailBoxesRepository;
    }
    @Override
    public MailBoxes createMailboxes(String email) {
        MailBoxes mailBoxes = new MailBoxes(email);

        return mailBoxesRepository.save(mailBoxes);
    }

    @Override
    public void addMessage(Message message) {

    }
}
