package com.example.EmailApplication.controllers;

import com.example.EmailApplication.data.models.MailBox;
import com.example.EmailApplication.data.models.User;
import com.example.EmailApplication.dtos.requests.CreateUserRequest;
import com.example.EmailApplication.dtos.responses.ApiResponse;
import com.example.EmailApplication.dtos.responses.LoginResponse;
import com.example.EmailApplication.dtos.responses.UserResponse;
import com.example.EmailApplication.exceptions.LoginException;
import com.example.EmailApplication.exceptions.UserException;
import com.example.EmailApplication.services.MailboxesService;
import com.example.EmailApplication.services.MailboxesServiceImpl;
import com.example.EmailApplication.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class UserController {
    private final UserService userService;
    private MailboxesServiceImpl mailboxesService;
    public UserController(UserService userService,MailboxesServiceImpl mailboxesService) {
        this.userService = userService;
        this.mailboxesService = mailboxesService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        UserResponse response = userService.createUser(request);

        try {
          ApiResponse apiResponse = ApiResponse.builder()
                  .payload(response)
                  .isSuccessful(true)
                  .statusCode(201)
                  .message("User Created Successfully")
                  .build();
          return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch(UserException ex){
            ApiResponse apiResponse = ApiResponse.builder()
                    .message(ex.getMessage())
                    .isSuccessful(false)
                    .statusCode(400)
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/inbox/{email}")
    public ResponseEntity<?> getAllInbox(@PathVariable  String email){
        List<MailBox> allInboxes = mailboxesService.viewAllInboxes(email);
        try {
            ApiResponse apiResponse = ApiResponse.builder()
                    .payload(allInboxes)
                    .isSuccessful(true)
                    .statusCode(200)
                    .message("All Inboxes Displayed")
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch(LoginException ex){
            ApiResponse apiResponse = ApiResponse.builder()
                    .message(ex.getMessage())
                    .isSuccessful(false)
                    .statusCode(400)
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody CreateUserRequest request){
        LoginResponse response = userService.login(request);

        try {
            ApiResponse apiResponse = ApiResponse.builder()
                    .payload(response)
                    .statusCode(200)
                    .isSuccessful(true)
                    .message("User Signed In Successfully")
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.FOUND);
        }
        catch(UserException ex){
            ApiResponse apiResponse = ApiResponse.builder()
                    .message(ex.getMessage())
                    .isSuccessful(false)
                    .statusCode(400)
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
        }
    }


}
