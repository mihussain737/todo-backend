package com.todo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderImpl {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("imam"));
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
