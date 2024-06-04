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
        return productRepo.save(product);
    }

    @Override
    public String RemoveProduct(Long id) {
        productRepo.deleteById(id);
        return "Product removed";
    }

    @Override
    public Product UpdateProduct(Product product) {
        Product P = productRepo.findById(product.getIdProduct()).get();
        P.setName(product.getName());
        P.setPrice(product.getPrice());
        P.setDescription(product.getDescription());
        productRepo.save(P);
        return P;
    }

    @Override
    public Product GetProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> GetAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
}
