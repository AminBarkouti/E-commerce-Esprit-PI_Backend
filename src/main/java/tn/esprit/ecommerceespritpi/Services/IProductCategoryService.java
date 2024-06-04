package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    ProductCategory getProductCategory(Long id);
    List<ProductCategory> getAllProductCategories();
    ProductCategory addProductCategory(ProductCategory productCategory);
    ProductCategory updateProductCategory(ProductCategory productCategory);
    String deleteProductCategory(Long id);
}
