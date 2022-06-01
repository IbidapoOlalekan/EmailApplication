package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.data.models.Message;
import com.example.EmailApplication.data.repositories.MessageRepository;
import com.example.EmailApplication.dtos.requests.MessageRequest;
import com.example.EmailApplication.dtos.responses.MessageResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService{
    private MessageRepository messageRepository;
    private MailboxesServiceImpl mailboxesService;
    public MessageServiceImpl(MessageRepository messageRepository, MailboxesServiceImpl mailboxesService){
        this.messageRepository = messageRepository;
        this.mailboxesService = mailboxesService;
    }
    @Override
    public void createMessageFolder(MailBox mailBox) {
        messageRepository.saveAll(mailBox.getMessages());
    }

    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest, String emailAddress) {
        Message incomingMessage = new Message();
        incomingMessage.setMessageBody(messageRequest.getMessageBody());
        incomingMessage.setDate(LocalDateTime.now());
        incomingMessage.setSender(emailAddress);

        incomingMessage.getReceiver().add(messageRequest.getRecipient());
        Message savedMessage = messageRepository.save(incomingMessage);
        mailboxesService.addMessage(savedMessage);
        String response = "Message Have Been Sent Successfully";
        MessageResponse responses = new MessageResponse();
        responses.setResponseMessage(response);
        return responses;
    }
}
