package com.hotel.service.impl;

import com.hotel.model.CategoryRoom;
import com.hotel.repository.CategoryRoomRepository;
import com.hotel.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryRoomServiceImpl implements CategoryRoomService {
    @Autowired
    private CategoryRoomRepository categoryRoomRepository;

    @Override
    public Iterable<CategoryRoom> findAll() {
        return categoryRoomRepository.findAll();
    }

    @Override
    public CategoryRoom findById(Long id) {
        return categoryRoomRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        categoryRoomRepository.delete(id);
    }

    @Override
    public void save(CategoryRoom categoryRoom) {
        categoryRoomRepository.save(categoryRoom);
    }
}
