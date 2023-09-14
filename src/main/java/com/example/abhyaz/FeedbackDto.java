package com.example.abhyaz;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackDto {
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email must be a valid email address")
    private String emailAddress;
    @NotEmpty(message = "subject must not be empty")
    private String subject;
    @NotEmpty(message = "message must not be empty")
    private String message;
}
