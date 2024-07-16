package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.Product;
import tn.esprit.ecommerceespritpi.ResponceMessage.ApiResponse;
import tn.esprit.ecommerceespritpi.Services.IProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public List<Product> getProducts(@RequestParam(value = "type", required = false) String type,
                                     @RequestParam(value = "category", required = false) String category) {
        if (type != null) {
            return productService.getProductsByType(type);
        } else if (category != null) {
            return productService.getProductsByCategory(category);
        }
        return productService.GetAllProducts();
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        for (Product product : products) {
            productService.AddProduct(product);
        }
        return products;
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product a) {
        return productService.AddProduct(a);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable("id") Long id) {
        String message = productService.RemoveProduct(id);
        ApiResponse<Void> apiResponse = new ApiResponse<>(null, message);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
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
