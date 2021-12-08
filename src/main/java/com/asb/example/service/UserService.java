package com.asb.example.service;

import com.asb.example.Enums.roleTypeEnum;
import com.asb.example.dto.ProductDto;
import com.asb.example.dto.UserDto;
import com.asb.example.model.Product;
import com.asb.example.model.userEntity;
import com.asb.example.repo.RoleRepository;
import com.asb.example.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<userEntity> userEntities = userRepository.findAll();
        userEntities.stream().forEach(product -> {
            UserDto userDto = mapEntityToDto(product);
            userDtos.add(userDto);
        });
        return userDtos;
    }

@Autowired
private RoleRepository roleRepository;

    public void save(MultipartFile image, String firstName, String lastName, String phoneNumber, String adress, String roleType , String email, String password) throws IOException
    {
        userEntity user=new userEntity();
        user.setEmail(email);
        user.setAddress(adress);
        user.setFirstName(firstName);
        user.setPassword(password);
        user.setProfileImage(image.getBytes());
        user.setPhoneNumber(phoneNumber);
        user.setLastName(lastName);
        switch (roleType) {
            case "ADMIN":
                user.setRoleentity(this.roleRepository.findById(1L).get());
                break;
            case "BOSS":
                user.setRoleentity(this.roleRepository.findById(3L).get());
                break;
            case "SUPERUSER":
                user.setRoleentity(this.roleRepository.findById(4L).get());
                break;
            case "USER":
                user.setRoleentity(this.roleRepository.findById(2L).get());
                break;
            default:
                //throw new Exception
        }
        this.userRepository.save(user);
    }

    @Autowired
    private ModelMapper modelMapper;

    private UserDto mapEntityToDto(userEntity user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        //userDto.setUserId(user.getUserId());
        //userDto.setFirstName(user.getFirstName());
        /*productDto.setPrix(product.getPrix());
        productDto.setQuantity(product.getQuantity());
        productDto.setName(product.getName());
        productDto.setDatefondation(product.getDatefondation());
        productDto.setCategory(product.getCategory());*/
        //productDto.setPaniers(product.getPaniers().);
        return userDto;
    }
    /*
    public List<Product> getproduct(){
        return this.productRepository.findAll();
    }*/


    private userEntity mapDtoToEntity(UserDto userDto) throws ParseException {
        userEntity user = modelMapper.map(userDto, userEntity.class);
        //product.setProduct_ID(productDto.getID());
        //user.setFirstName(userDto.getFirstName());
       // user.setUserId(userDto.getUserId());
       /* product.setPrix(productDto.getPrix());
        product.setQuantity(productDto.getQuantity());
        product.setDatefondation(productDto.getDatefondation());
        product.setPaniers(product.getPaniers());
        product.setCategory(productDto.getCategory());*/
/*
        if (product.getProduct_ID() != null) {
            Product oldPost = .getPostById(postDto.getId());
            post.setRedditID(oldPost.getRedditID());
            post.setSent(oldPost.isSent());
        }*/
        return user;
    }
}
