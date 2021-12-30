package com.asb.example.controller.authController;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
