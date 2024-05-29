package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.Product;

import java.util.List;

public interface IProductService {
    Product AddProduct(Product product);
    void RemoveProduct(Product product);
    Product UpdateProduct(Product product);
    Product GetProductById(Long id);
    List<Product> GetAllProducts();

}
