package com.asb.example.repo;

import com.asb.example.model.ListCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListCommandeRepository extends JpaRepository<ListCommande,Long> {
}
