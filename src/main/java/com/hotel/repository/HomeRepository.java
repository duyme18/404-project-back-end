package com.hotel.repository;

import com.hotel.model.CategoryHome;
import com.hotel.model.CategoryRoom;
import com.hotel.model.Home;
import com.hotel.model.StatusHome;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HomeRepository extends PagingAndSortingRepository<Home, Long> {
    Iterable<Home> findAllByCategoryHome(CategoryHome categoryHome);

    Iterable<Home> findAllByCategoryRoom(CategoryRoom categoryRoom);

    Iterable<Home> findAllByStatusHome(StatusHome statusHome);
}
