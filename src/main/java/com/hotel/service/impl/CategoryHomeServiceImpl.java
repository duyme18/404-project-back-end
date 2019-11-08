package com.hotel.service.impl;

import com.hotel.model.CategoryHome;
import com.hotel.repository.CategoryHomeRepository;
import com.hotel.service.CategoryHomeService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryHomeServiceImpl implements CategoryHomeService {
    @Autowired
    private CategoryHomeRepository categoryHomeRepository;

    @Override
    public Iterable<CategoryHome> findAll() {
        return categoryHomeRepository.findAll();
    }

    @Override
    public CategoryHome findById(Long id) {
        return categoryHomeRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        categoryHomeRepository.delete(id);
    }

    @Override
    public void save(CategoryHome categoryHome) {
        categoryHomeRepository.save(categoryHome);
    }
}
