package com.asb.example.dto;

import com.asb.example.model.Commande;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListCommandeDto {
    private Long listCommandeId;
    private List<String> commandes=new ArrayList<>();
}
