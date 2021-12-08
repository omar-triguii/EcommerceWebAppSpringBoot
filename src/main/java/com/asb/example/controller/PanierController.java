package com.asb.example.controller;

import com.asb.example.dto.PanierDto;
import com.asb.example.dto.ProductDto;
import com.asb.example.dto.StudentDto;
import com.asb.example.model.Product;
import com.asb.example.service.PanierService;
import com.asb.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @DeleteMapping("/panier/{id}")
    public ResponseEntity<String> deletePanier(@PathVariable(name = "id") Long studentId) {
        String message = panierService.deletePanier(studentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @PostMapping("/panier")
    public ResponseEntity<PanierDto> getAllPaniers(@RequestBody PanierDto panierDto) throws ParseException {
        PanierDto std = panierService.addPanier(panierDto);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }


    @DeleteMapping("/panierproduct/{id}/{id2}")
    public ResponseEntity<String> deletePanierProduct(@PathVariable(name = "id") Long panierID,@PathVariable(name = "id2") Long productId ) {
        String message = panierService.deleteProduct_Panier(panierID,productId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
