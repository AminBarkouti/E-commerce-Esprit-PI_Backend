package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.Commande;
import tn.esprit.ecommerceespritpi.Entities.Product;

public interface ICommandeRepository extends CrudRepository<Commande,Long> {
}
