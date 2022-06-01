package com.example.EmailApplication.services;

import com.example.EmailApplication.data.Entities.UserEntity;
import com.example.EmailApplication.data.models.MailBoxes;
import com.example.EmailApplication.data.models.User;
import com.example.EmailApplication.data.repositories.MailBoxesRepository;
import com.example.EmailApplication.data.repositories.UserRepository;
import com.example.EmailApplication.dtos.requests.CreateUserRequest;
import com.example.EmailApplication.dtos.responses.LoginResponse;
import com.example.EmailApplication.dtos.responses.UserResponse;
import com.example.EmailApplication.exceptions.LoginException;
import com.example.EmailApplication.exceptions.UserException;
import jdk.jshell.spi.ExecutionControl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private MailboxesService mailBoxService;

    @Autowired
    private UserRepository userRepository;

    private final ModelMapper mapper = new ModelMapper();


    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse createUser(CreateUserRequest request) {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if (user.isEmpty()){
            User users = new User(request.getEmail(),request.getPassword());
            MailBoxes boxes = new MailBoxes();
            mailBoxService.createMailboxes(request.getEmail());
            userRepository.save(users);
            UserResponse response = new UserResponse();
            response.setEmail(request.getEmail());
            return response;
        }
        else{
            throw new UserException("User Exist Already");
        }

    }

    @Override
    public LoginResponse login(CreateUserRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(()-> new UserException("User Not Found"));
        LoginResponse response = new LoginResponse();

        if(!user.isLoggedIn()){
            if (user.getPassword().equals(request.getPassword())) {
                user.setLoggedIn(true);
                User savedUser = userRepository.save(user);
                response.setSuccessful(true);
                mapper.map(request, response);
                return response;
            }
            else throw new LoginException("Invalid Details");
        }
        return new LoginResponse("User Already Logged In",false);
    }
}
