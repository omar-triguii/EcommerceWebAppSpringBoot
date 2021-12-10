package com.asb.example.controller;

import com.asb.example.dto.CommandeDto;
import com.asb.example.dto.PanierDto;
import com.asb.example.model.Commande;
import com.asb.example.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    private CommandeService commandeService;
    @PostMapping("addCommandeToPanier/{panierId}")
    public ResponseEntity<CommandeDto> addCommandeToPanier(@PathVariable Long panierId){
        CommandeDto commandeDto = commandeService.addCommandeToPanier(panierId);
        return new ResponseEntity<>(commandeDto, HttpStatus.OK);
    }
    @DeleteMapping("delete/{panierId}")
    public String deletepanier(@PathVariable Long panierId){
        return this.commandeService.deletePanierAfterCommande(panierId);
    }
}
