package tn.esprit.ecommerceespritpi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.Category;
import tn.esprit.ecommerceespritpi.Repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryImp implements ICategoryService {
    @Autowired
    ICategoryRepository CategoryRepo;
    @Override
    public Category getCategory(Long id) {
        return CategoryRepo.findById(id).get();
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) CategoryRepo.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return CategoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category cat = CategoryRepo.findById(category.getId()).get();
        cat.setTitle(category.getTitle());
        CategoryRepo.save(cat);
        return cat;
    }

    @Override
    public String deleteCategory(Long id) {
        CategoryRepo.deleteById(id);
        return " category deleted";
    }
}
