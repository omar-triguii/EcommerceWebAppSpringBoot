package com.asb.example.dto;

import com.asb.example.model.roleEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    private byte[] profileImage;

    private roleEntity roleentity;

}
