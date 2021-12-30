package com.asb.example.repo;

import com.asb.example.model.roleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<roleEntity,Long> {
    roleEntity findByDescription(String description);
}
