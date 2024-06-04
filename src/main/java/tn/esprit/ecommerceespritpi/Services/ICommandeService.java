package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.Commande;

import java.util.List;

public interface ICommandeService {
    Commande AddCommande(Commande commande);
    void RemoveCommande(Long id);
    Commande UpdateCommande(Commande commande);
    Commande GetCommandeById(Long id);
    List<Commande> GetAllCommandes();
}
