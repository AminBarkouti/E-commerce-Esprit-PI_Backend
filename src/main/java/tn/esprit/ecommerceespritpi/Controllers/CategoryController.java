package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.Category;
import tn.esprit.ecommerceespritpi.Services.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    ICategoryService CategoryService;

    @GetMapping("/listCategory")
    public List<Category> getCategorys() {
        return CategoryService.getAllCategories();
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return CategoryService.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        return CategoryService.deleteCategory(id);
    }

    @GetMapping("/getById/{id}")
    public Category getById(@PathVariable("id") Long id) {
        return CategoryService.getCategory(id);
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        return CategoryService.updateCategory(category);
    }
}
