package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ecommerceespritpi.Services.IProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
    IProductService productService;

}
