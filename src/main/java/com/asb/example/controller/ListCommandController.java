package com.asb.example.controller;

import com.asb.example.model.ListCommande;
import com.asb.example.service.ListCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListCommandController {
    @Autowired
    private ListCommandeService listCommandeService;
    @GetMapping("omar")
    public List<ListCommande> omar(){
        return this.listCommandeService.getListCommand();
    }
}
