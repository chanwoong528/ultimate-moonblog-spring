package com.moon.moonblogserver.category;

import com.moon.moonblogserver.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category oneCategory(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
    }

    public Category createdOneCategory(String label, String description) {
        Category newCategory = new Category(label, description);
        return categoryRepository.save(newCategory);
    }

    public Category updateOneCategory(UUID id, String label, String description) {
        Category tobeUpdatedCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        if (!label.isEmpty()) {
            tobeUpdatedCategory.setLabel(label);
        }
        if (!description.isEmpty()) {
            tobeUpdatedCategory.setDescription(description);
        }
        return categoryRepository.save(tobeUpdatedCategory);
    }


}
