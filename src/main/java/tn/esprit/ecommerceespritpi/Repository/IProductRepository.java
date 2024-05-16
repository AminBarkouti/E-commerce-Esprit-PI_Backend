package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.Product;

public interface IProductRepository extends CrudRepository<Product,Long> {
}
