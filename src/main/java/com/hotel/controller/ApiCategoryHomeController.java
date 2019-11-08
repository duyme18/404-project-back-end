package com.hotel.controller;

import com.hotel.model.CategoryHome;
import com.hotel.service.CategoryHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ApiCategoryHomeController {
    @Autowired
    private CategoryHomeService categoryHomeService;

    @GetMapping("/api/category-home")
    public ResponseEntity<List<CategoryHome>> getCategoryRoomList(){
        List<CategoryHome> categoryHomes = (List<CategoryHome>) categoryHomeService.findAll();

        if(categoryHomes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryHomes,HttpStatus.OK);
    }

    @GetMapping("/api/category-home/{id}")
    public ResponseEntity<CategoryHome> getCategoryHome(@PathVariable Long id){
        CategoryHome categoryHome = categoryHomeService.findById(id);

        if(categoryHome == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoryHome,HttpStatus.OK);
    }

    @PostMapping("/api/category-home")
    public ResponseEntity<Void> createCategoryHome(@RequestBody CategoryHome categoryHome) {
        categoryHomeService.save(categoryHome);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/category-home/{id}")
    public ResponseEntity<CategoryHome> editCategory(@RequestBody CategoryHome categoryHome, @PathVariable Long id){
        CategoryHome category1 = categoryHomeService.findById(id);
        if(category1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        category1.setName(categoryHome.getName());
        categoryHomeService.save(category1);

        return new ResponseEntity<>(category1,HttpStatus.OK);
    }

    @DeleteMapping("/api/category-home/{id}")
    public ResponseEntity<Void> deleteCategoryHome(@PathVariable Long id){
        CategoryHome categoryHome = categoryHomeService.findById(id);

        if(categoryHome == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoryHomeService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
