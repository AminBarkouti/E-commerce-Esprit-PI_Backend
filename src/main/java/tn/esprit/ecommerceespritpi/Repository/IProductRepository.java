package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.Product;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByType(String type);
    List<Product> findByCategory(String category);
}
