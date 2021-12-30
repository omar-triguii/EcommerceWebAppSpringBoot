package com.asb.example.controller;

import com.asb.example.Enums.roleTypeEnum;
import com.asb.example.dto.ProductDto;
import com.asb.example.dto.UserDto;
import com.asb.example.service.ProductService;
import com.asb.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("admin")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestParam("profileImage") MultipartFile profileImage, @RequestParam("FirstName") String firstName,
                                           @RequestParam("lastName") String lastName,@RequestParam("phoneNumber")String phoneNumber,
                                           @RequestParam("adress")String adress,@RequestParam("roletype") String roletype,
                                           @RequestParam("email") String email, @RequestParam("password") String password)
    {
        try {
            this.userService.save(profileImage, firstName,lastName,phoneNumber,adress,roletype, email, password);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("{userID}")
    public String addpanier(@PathVariable Long userID){
        return this.userService.addPanier(userID);
    }

}
