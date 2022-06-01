package com.example.EmailApplication.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id

    private String email;

    private String password;

    private List<Notification> notifications = new ArrayList<>();

    private boolean isLoggedIn;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
