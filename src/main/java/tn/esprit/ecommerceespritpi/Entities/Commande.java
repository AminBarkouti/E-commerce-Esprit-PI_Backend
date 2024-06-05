package tn.esprit.ecommerceespritpi.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Date dateCommande;
    private StatutCMD statut;
    @OneToOne
    private AdresseLivraison adresseLivraison;
}

