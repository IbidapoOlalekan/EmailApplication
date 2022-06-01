package com.example.EmailApplication.services;

import com.example.EmailApplication.dtos.requests.CreateUserRequest;
import com.example.EmailApplication.dtos.responses.LoginResponse;
import com.example.EmailApplication.dtos.responses.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);

    LoginResponse login(CreateUserRequest request);

}
