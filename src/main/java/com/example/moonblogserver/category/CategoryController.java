package com.example.moonblogserver.category;
//SQL

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List <Category>> getAllCategories(){
        List<Category> categories = categoryService.allCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<Category> postOneCategory(@RequestParam String label, String description){

        Category newCate  = categoryService.createdOneCategory(label, description);
        return new ResponseEntity<Category>(newCate, HttpStatus.CREATED);
    }
    @RequestMapping(value="{cateId}", method = RequestMethod.PATCH)
    public ResponseEntity<Category> patchOneCategory(@PathVariable("cateId") String id, @RequestParam String label, String description){
        Category updatedCate  = categoryService.updateOneCategory(UUID.fromString(id), label, description);
        return new ResponseEntity<Category>(updatedCate, HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="{cateId}", method = RequestMethod.GET)
    public ResponseEntity<Category> getOneCategory(@PathVariable("cateId") String id){
        Category onCate  = categoryService.oneCategory(UUID.fromString(id) );
        return ResponseEntity.status(HttpStatus.OK).body(onCate);
    }
}
