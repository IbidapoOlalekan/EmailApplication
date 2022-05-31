package com.example.EmailApplication.data.repositories;

import com.example.EmailApplication.data.models.MailBox;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailBoxRepository extends MongoRepository<MailBox,String> {
}
