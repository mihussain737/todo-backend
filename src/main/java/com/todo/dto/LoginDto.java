package com.todo.dto;
import lombok.*;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
