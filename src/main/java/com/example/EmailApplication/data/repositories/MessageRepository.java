package com.example.EmailApplication.data.repositories;

import com.example.EmailApplication.data.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message,String> {

}
