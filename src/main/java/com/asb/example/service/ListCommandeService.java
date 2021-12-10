package com.asb.example.service;

import com.asb.example.model.ListCommande;
import com.asb.example.repo.ListCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCommandeService {
    @Autowired
    private ListCommandeRepository listCommandeRepository;
    public List<ListCommande> getListCommand(){
        return this.listCommandeRepository.findAll();
    }
}
