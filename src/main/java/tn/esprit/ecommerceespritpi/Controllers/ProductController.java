package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.Product;
import tn.esprit.ecommerceespritpi.Services.IProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public List<Product> getProducts() {
        return productService.GetAllProducts();
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        for (Product product : products) {
            productService.AddProduct(product);
        }
        return products;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product a) {
        return productService.AddProduct(a);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        return productService.RemoveProduct(id);
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.GetProductById(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.UpdateProduct(product);
    }

}
