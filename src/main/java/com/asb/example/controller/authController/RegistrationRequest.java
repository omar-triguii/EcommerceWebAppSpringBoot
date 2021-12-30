package com.asb.example.controller.authController;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {

    @NotEmpty

    private String email;

    @NotEmpty
    private String password;
   // private Long roleId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
   }
