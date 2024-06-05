package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.AdresseLivraison;

public interface IAdresseRepository extends CrudRepository<AdresseLivraison, Long> {
}