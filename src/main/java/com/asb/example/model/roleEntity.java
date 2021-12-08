package com.asb.example.model;

import com.asb.example.Enums.roleTypeEnum;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roleEntity")
@Data
public class roleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column
    private roleTypeEnum roletype;
    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public roleEntity(Long roleId, roleTypeEnum roletype,String description) {
        this.roleId = roleId;
        this.roletype = roletype;
        this.description=description;
    }

    public roleEntity() {

    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public roleTypeEnum getRoletype() {
        return roletype;
    }

    public void setRoletype(roleTypeEnum roletype) {
        this.roletype = roletype;
    }
}
