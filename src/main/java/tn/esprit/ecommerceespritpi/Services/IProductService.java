package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.Product;

import java.util.List;

public interface IProductService {
    Product AddProduct(Product product);
    String RemoveProduct(Long id);
    Product UpdateProduct(Product product);
    Product GetProductById(Long id);
    List<Product> GetAllProducts();
    List<Product> getProductsByType(String type);
    List<Product> getProductsByCategory(String category);
}
