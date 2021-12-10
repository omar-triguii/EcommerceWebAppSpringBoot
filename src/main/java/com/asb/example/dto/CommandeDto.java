package com.asb.example.dto;

import com.asb.example.model.Panier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
public class CommandeDto {
    private Long commandeId;
    private String commandeName;
    private Date commandeDate;
    private Panier panier;
}
