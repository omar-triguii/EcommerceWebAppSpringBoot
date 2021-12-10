package com.asb.example.service;

import com.asb.example.dto.CommandeDto;
import com.asb.example.dto.PanierDto;
import com.asb.example.model.Commande;
import com.asb.example.model.ListCommande;
import com.asb.example.model.Panier;
import com.asb.example.repo.CommandeRepository;
import com.asb.example.repo.ListCommandeRepository;
import com.asb.example.repo.PanierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private ListCommandeRepository listCommandeRepository;

    ;
    @Transactional
    public CommandeDto addCommandeToPanier(Long panierId){
        Optional<Panier> panier =this.panierRepository.findById(panierId);
        Commande commande=new Commande();
        //commande.setListCommande();
        commande.setCommandeId(panierId);
        Date date = new Date(System.currentTimeMillis());
        commande.setCommandeDate(date);
        commande.setPanier(panier.get());
        commande.setCommandeName(panier.get().getUserEntity().getFirstName());

        commande.setListCommande(this.listCommandeRepository.getOne(1L));
      //  this.listCommandeRepository.findById(1L).get().addCommandeToList(commande);
        this.commandeRepository.save(commande);
        CommandeDto commandeDto = mapEntityToDto(commande);
        return commandeDto;

    }
    public String deletePanierAfterCommande(Long panierId){
        this.panierRepository.delete(this.panierRepository.getOne(panierId));
        this.commandeRepository.delete(this.commandeRepository.getOne(panierId));
        return "deleted";
    }

    @Autowired
    private ModelMapper modelMapper;

    private CommandeDto mapEntityToDto(Commande commande) {
        CommandeDto commandeDto = modelMapper.map(commande, CommandeDto.class);

        return commandeDto;
    }

    private Commande mapDtoToEntity(CommandeDto commandeDto) throws ParseException {
        Commande commande = modelMapper.map(commandeDto, Commande.class);
        return commande;
    }

}

