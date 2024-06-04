package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.ProductCategory;

public interface IProductCategoryRepository extends CrudRepository<ProductCategory,Long> {
}
