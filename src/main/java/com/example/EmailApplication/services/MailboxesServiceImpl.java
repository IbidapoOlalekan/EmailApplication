package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.*;
import com.example.EmailApplication.data.repositories.MailBoxesRepository;
import com.example.EmailApplication.data.repositories.UserRepository;
import com.example.EmailApplication.dtos.responses.MailResponse;
import com.example.EmailApplication.exceptions.EmailNotFoundException;
import com.example.EmailApplication.exceptions.LoginException;
import com.example.EmailApplication.exceptions.UserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailboxesServiceImpl implements MailboxesService{
    private MailBoxesRepository mailBoxesRepository;
    private UserRepository userRepository;
    public MailboxesServiceImpl(MailBoxesRepository mailBoxesRepository, UserRepository userRepository){
        this.mailBoxesRepository = mailBoxesRepository;
        this.userRepository = userRepository;
    }
    @Override
    public MailBoxes createMailboxes(String email) {
        MailBoxes mailBoxes = new MailBoxes(email);

        return mailBoxesRepository.save(mailBoxes);
    }

    @Override
    public void addMessage(Message message) {

    }

    @Override
    public MailResponse viewAllInboxes(String emailAddress) {
        MailBoxes mailBoxes = mailBoxesRepository.findById(emailAddress).orElseThrow(()-> new EmailNotFoundException("Email not found"));
        User user  = userRepository.findUserByEmail(emailAddress).orElseThrow(()-> new UserException("User does not exist"));
        if (user.isLoggedIn()){
            MailResponse response = new MailResponse();
            response.setUsername(emailAddress);
            response.setMailBox(mailBoxes.getBoxes()
                    .stream()
                    .parallel()
                    .filter(mailBox -> mailBox.getMailType() == Type.INBOX)
                    .collect(Collectors.toList()));
            return response;

        }
        throw new LoginException("User is not logged in");
    }

    @Override
    public List<MailBox> viewAllSent(String emailAddress) {
        MailBoxes mailBoxes = mailBoxesRepository.findById(emailAddress).orElseThrow(()->new EmailNotFoundException("Email Not Found"));
        User user = userRepository.findUserByEmail(emailAddress).orElseThrow(()->new UserException("User Not Found "));
        if (user.isLoggedIn()){
            return mailBoxes.getBoxes()
                    .stream()
                    .parallel()
                    .filter(mailBox->mailBox.getMailType()==Type.SENT)
                    .collect(Collectors.toList());
        }
        throw new LoginException("User is Not logged in");
    }
}
