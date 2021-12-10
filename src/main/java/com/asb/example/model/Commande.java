package com.asb.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commandeId;
    private String commandeName;
    private Date commandeDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "panier_ID", referencedColumnName = "panier_ID")
    private Panier panier;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listeCommandeId")
    @JsonIgnore
    private ListCommande listCommande;

    public Commande(Long commandeId, String commandeName, Date commandeDate, Panier panier,ListCommande listCommande) {
        this.commandeId = commandeId;
        this.commandeName = commandeName;
        this.commandeDate = commandeDate;
        this.panier = panier;
        this.listCommande=listCommande;
    }

    public Commande() {

    }
}
