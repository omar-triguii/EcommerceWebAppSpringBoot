package com.asb.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "userEntity")
@Data

public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phoneNumber;
    @Column
    private String address;
    @Column
    private byte[] profileImage;

    public userEntity(Long userId, String firstName, String lastName, String email, String password, String phoneNumber, String address,byte[] profileImage ,roleEntity roleentity) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profileImage = profileImage;
        this.roleentity = roleentity;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private roleEntity roleentity;


    @JsonIgnore
    @OneToOne(mappedBy = "userEntity")
    private Panier panier;

    public userEntity() {

    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
/*
    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }
    */

    public roleEntity getRoleentity() {
        return roleentity;
    }

    public void setRoleentity(roleEntity roleentity) {
        this.roleentity = roleentity;
    }
}
