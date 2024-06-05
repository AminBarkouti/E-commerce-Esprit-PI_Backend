package tn.esprit.ecommerceespritpi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.AdresseLivraison;
import tn.esprit.ecommerceespritpi.Repository.IAdresseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseServiceImp implements IAdresseService {

    @Autowired
    private IAdresseRepository adresseRepository;

    @Override
    public AdresseLivraison AddLivraison(AdresseLivraison adresseLivraison) {
        return adresseRepository.save(adresseLivraison);
    }

    @Override
    public void RemoveAdresse(Long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public AdresseLivraison UpdateLivraison(AdresseLivraison adresseLivraison) {
        return adresseRepository.save(adresseLivraison);
    }

    @Override
    public AdresseLivraison GetLivraisonById(Long id) {
        Optional<AdresseLivraison> optionalLivraison = adresseRepository.findById(id);
        return optionalLivraison.orElse(null);
    }

    @Override
    public List<AdresseLivraison> GetAllLivraison() {
        return (List<AdresseLivraison>) adresseRepository.findAll();
    }
}
