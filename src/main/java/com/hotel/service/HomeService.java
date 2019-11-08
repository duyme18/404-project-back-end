package com.hotel.service;

import com.hotel.model.CategoryHome;
import com.hotel.model.CategoryRoom;
import com.hotel.model.Home;
import com.hotel.model.StatusHome;

public interface HomeService {
    Iterable<Home> findAll();

    Home findById(Long id);

    void remove(Long id);

    void save(Home home);

    Iterable<Home> findAllByCategoryHome(CategoryHome categoryHome);

    Iterable<Home> findAllByCategoryRoom(CategoryRoom categoryRoom);

    Iterable<Home> findAllByStatusHome(StatusHome statusHome);
}
