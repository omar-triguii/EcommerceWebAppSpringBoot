package com.asb.example.controller;

import com.asb.example.dto.PanierDto;
import com.asb.example.dto.ProductDto;
import com.asb.example.dto.StudentDto;
import com.asb.example.service.PanierService;
import com.asb.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class PanierController {

    @Autowired
    private PanierService panierService;

    @GetMapping("/paniers")
    public ResponseEntity<List<PanierDto>> getAllStudents() {
        List<PanierDto> paniers = panierService.getAllPaniers();
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }


    @PostMapping("/panier")
    public ResponseEntity<PanierDto> getAllPaniers(@RequestBody PanierDto panierDto) throws ParseException {
        PanierDto std = panierService.addPanier(panierDto);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

}
