package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.AdresseLivraison;
import tn.esprit.ecommerceespritpi.Entities.Commande;

import java.util.List;

public interface IAdresseService {
    AdresseLivraison AddLivraison (AdresseLivraison adresseLivraison);
    void RemoveAdresse(Long id);
    AdresseLivraison UpdateLivraison (AdresseLivraison adresseLivraison);
    AdresseLivraison GetLivraisonById(Long id);
    List<AdresseLivraison> GetAllLivraison ();
}
