package com.example.EmailApplication.dtos.responses;

import com.example.EmailApplication.data.models.MailBox;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailResponse {
    private String username;
    private List<MailBox> mailBox;
}
