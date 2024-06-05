package tn.esprit.ecommerceespritpi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.ProductCategory;
import tn.esprit.ecommerceespritpi.Repository.IProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryImp implements IProductCategoryService {
    @Autowired
    IProductCategoryRepository productCategoryRepo;
    @Override
    public ProductCategory getProductCategory(Long id) {
        return productCategoryRepo.findById(id).get();
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return (List<ProductCategory>) productCategoryRepo.findAll();
    }

    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        return productCategoryRepo.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        ProductCategory Prod = productCategoryRepo.findById(productCategory.getIdCategory()).get();
        Prod.setName(productCategory.getName());
        productCategoryRepo.save(Prod);
        return Prod;
    }

    @Override
    public String deleteProductCategory(Long id) {
        productCategoryRepo.deleteById(id);
        return "product category deleted";
    }
}
