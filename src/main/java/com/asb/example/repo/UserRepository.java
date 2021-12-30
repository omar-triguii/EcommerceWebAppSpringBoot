package com.asb.example.repo;

import com.asb.example.model.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<userEntity,Long> {
    userEntity findByEmail(String email);
}
