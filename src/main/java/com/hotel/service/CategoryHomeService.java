package com.hotel.service;

import com.hotel.model.CategoryHome;

public interface CategoryHomeService {
    Iterable<CategoryHome> findAll();

    CategoryHome findById(Long id);

    void remove(Long id);

    void save(CategoryHome categoryHome);
}
