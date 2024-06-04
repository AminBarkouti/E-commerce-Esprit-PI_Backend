package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.Commande;
import tn.esprit.ecommerceespritpi.Services.ICommandeService;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private ICommandeService commandeService;

    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        Commande newCommande = commandeService.AddCommande(commande);
        return ResponseEntity.ok(newCommande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCommande(@PathVariable Long id) {
        commandeService.RemoveCommande(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        Commande existingCommande = commandeService.GetCommandeById(id);
        if (existingCommande == null) {
            return ResponseEntity.notFound().build();
        }
        commande.setIdCommande(id);
        Commande updatedCommande = commandeService.UpdateCommande(commande);
        return ResponseEntity.ok(updatedCommande);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.GetCommandeById(id);
        if (commande == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commande);
    }

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> commandes = commandeService.GetAllCommandes();
        return ResponseEntity.ok(commandes);
    }
}
