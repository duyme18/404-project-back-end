package com.hotel.service;

import com.hotel.model.CategoryRoom;

public interface CategoryRoomService {
    Iterable<CategoryRoom> findAll();

    CategoryRoom findById(Long id);

    void remove(Long id);

    void save(CategoryRoom categoryRoom);
}
