package com.asb.example.dto;

import com.asb.example.Enums.roleTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class RoleDto {

    private Long roleId;

    private roleTypeEnum roletype;

    private String description;
}
