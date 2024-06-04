package tn.esprit.ecommerceespritpi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.Commande;
import tn.esprit.ecommerceespritpi.Repository.ICommandeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImp implements ICommandeService {

    @Autowired
    private ICommandeRepository commandeRepository;

    @Override
    public Commande AddCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void RemoveCommande(Long id) {
        commandeRepository.deleteById(id);
    }


    @Override
    public Commande UpdateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande GetCommandeById(Long id) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        return optionalCommande.orElse(null);
    }

    @Override
    public List<Commande> GetAllCommandes() {
        return (List<Commande>) commandeRepository.findAll();
    }
}
