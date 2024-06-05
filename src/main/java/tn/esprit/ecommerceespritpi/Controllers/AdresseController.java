package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.AdresseLivraison;
import tn.esprit.ecommerceespritpi.Services.IAdresseService;

import java.util.List;

@RestController
@RequestMapping("/adresse")
public class AdresseController {

    @Autowired
    private IAdresseService adresseService;

    @PostMapping("/add")
    public ResponseEntity<AdresseLivraison> addAdresseLivraison(@RequestBody AdresseLivraison adresseLivraison) {
        AdresseLivraison newAdresseLivraison = adresseService.AddLivraison(adresseLivraison);
        return new ResponseEntity<>(newAdresseLivraison, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAdresseLivraison(@PathVariable Long id) {
        adresseService.RemoveAdresse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<AdresseLivraison> updateAdresseLivraison(@RequestBody AdresseLivraison adresseLivraison) {
        AdresseLivraison updatedAdresseLivraison = adresseService.UpdateLivraison(adresseLivraison);
        return new ResponseEntity<>(updatedAdresseLivraison, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdresseLivraison> getAdresseLivraisonById(@PathVariable Long id) {
        AdresseLivraison adresseLivraison = adresseService.GetLivraisonById(id);
        if (adresseLivraison != null) {
            return new ResponseEntity<>(adresseLivraison, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdresseLivraison>> getAllAdressesLivraison() {
        List<AdresseLivraison> adressesLivraison = adresseService.GetAllLivraison();
        return new ResponseEntity<>(adressesLivraison, HttpStatus.OK);
    }
}
