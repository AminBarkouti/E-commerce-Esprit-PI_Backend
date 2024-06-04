package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.Product;
import tn.esprit.ecommerceespritpi.Entities.ProductCategory;
import tn.esprit.ecommerceespritpi.Services.IProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/ProductCategory")
public class ProductCategoryController {
    IProductCategoryService productCategoryService;

    @GetMapping("/listProductCategory")
    public List<ProductCategory> getProductCategorys() {
        return productCategoryService.getAllProductCategories();
    }

    @PostMapping("/addProductCategory")
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.addProductCategory(productCategory);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductCategory(@PathVariable("id") Long id){
        return productCategoryService.deleteProductCategory(id);
    }

    @GetMapping("/getById/{id}")
    public ProductCategory getById(@PathVariable("id") Long id) {
        return productCategoryService.getProductCategory(id);
    }

    @PutMapping("/updateProductCategory")
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.updateProductCategory(productCategory);
    }
}
