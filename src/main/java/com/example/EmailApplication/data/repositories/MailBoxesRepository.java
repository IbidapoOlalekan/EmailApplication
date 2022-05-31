package com.example.EmailApplication.data.repositories;

import com.example.EmailApplication.data.models.MailBoxes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailBoxesRepository extends MongoRepository<MailBoxes,String> {
}
