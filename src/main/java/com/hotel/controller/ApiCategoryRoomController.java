package com.hotel.controller;

import com.hotel.model.CategoryRoom;
import com.hotel.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ApiCategoryRoomController {
    @Autowired
    private CategoryRoomService categoryRoomService;

    @GetMapping("/api/category-room")
    public ResponseEntity<List<CategoryRoom>> getCategoryRoomList(){
        List<CategoryRoom> categories = (List<CategoryRoom>) categoryRoomService.findAll();

        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/api/category-room/{id}")
    public ResponseEntity<CategoryRoom> getCategoryRoom(@PathVariable Long id){
        CategoryRoom categoryRoom = categoryRoomService.findById(id);

        if(categoryRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoryRoom,HttpStatus.OK);
    }

    @PostMapping("/api/category-room")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryRoom categoryRoom) {
        categoryRoomService.save(categoryRoom);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/category-room/{id}")
    public ResponseEntity<CategoryRoom> editCategory(@RequestBody CategoryRoom categoryRoom, @PathVariable Long id){
        CategoryRoom category1 = categoryRoomService.findById(id);
        if(category1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        category1.setName(categoryRoom.getName());
        categoryRoomService.save(category1);

        return new ResponseEntity<>(category1,HttpStatus.OK);
    }

    @DeleteMapping("/api/category-room/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        CategoryRoom categoryRoom = categoryRoomService.findById(id);

        if(categoryRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoryRoomService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
