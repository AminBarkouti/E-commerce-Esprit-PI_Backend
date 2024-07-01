package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategory(Long id);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category);
    String deleteCategory(Long id);
}
