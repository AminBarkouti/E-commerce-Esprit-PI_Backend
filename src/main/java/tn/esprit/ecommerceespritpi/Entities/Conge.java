package tn.esprit.ecommerceespritpi.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConge;
    private Date dateDebut;
    private Date dateFin;
    private StatutConge statutConge;
}
