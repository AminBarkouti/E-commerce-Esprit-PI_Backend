package tn.esprit.ecommerceespritpi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.Product;
import tn.esprit.ecommerceespritpi.Repository.IProductRepository;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService{

    @Autowired
    IProductRepository productRepo;

    @Override
    public Product AddProduct(Product product) {
        return null;
    }

    @Override
    public void RemoveProduct(Product product) {

    }

    @Override
    public Product UpdateProduct(Product product) {
        return product;
    }

    @Override
    public Product GetProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> GetAllProducts() {
        return List.of();
    }
}
