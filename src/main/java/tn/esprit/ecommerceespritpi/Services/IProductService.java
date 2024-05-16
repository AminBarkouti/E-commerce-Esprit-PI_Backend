package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.Product;

import java.util.List;

public interface IProductService {
    Product AddProduct(Product product);
    void RemoveProduct(Product product);
    void UpdateProduct(Product product);
    Product GetProductById(int id);
    List<Product> GetAllProducts();

}
