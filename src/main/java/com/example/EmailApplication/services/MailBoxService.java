package com.example.EmailApplication.services;

import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.dtos.responses.MailBoxCreationResponse;

public interface MailBoxService {
    MailBoxCreationResponse openMail(MailBoxes mailBoxes);

}
