package com.example.EmailApplication.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CreateUserRequest {
    @Id
    private String email;
    private String password;
}
