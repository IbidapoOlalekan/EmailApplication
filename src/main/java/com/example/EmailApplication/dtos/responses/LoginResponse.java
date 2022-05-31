package com.example.EmailApplication.dtos.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String email;
    private boolean isSuccessful;
}
