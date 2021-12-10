package com.asb.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class ListCommande {
    @Id
    private Long listCommandeId;

    @OneToMany(mappedBy = "listCommande",cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Commande> commandes ;

    public ListCommande() {

    }

    public void addCommandeToList(Commande commande){
        this.commandes.add(commande);
    }

    public ListCommande(Long listCommandeId, List<Commande> commandes) {
        this.listCommandeId = listCommandeId;
        this.commandes = commandes;
    }
}
