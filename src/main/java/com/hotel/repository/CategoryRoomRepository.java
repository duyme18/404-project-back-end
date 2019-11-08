package com.hotel.repository;

import com.hotel.model.CategoryRoom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRoomRepository extends PagingAndSortingRepository<CategoryRoom, Long> {
}
