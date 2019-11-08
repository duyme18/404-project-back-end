package com.hotel.service.impl;

import com.hotel.model.CategoryHome;
import com.hotel.model.CategoryRoom;
import com.hotel.model.Home;
import com.hotel.model.StatusHome;
import com.hotel.repository.HomeRepository;
import com.hotel.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Home findById(Long id) {
        return homeRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        homeRepository.delete(id);
    }

    @Override
    public void save(Home home) {
        homeRepository.save(home);
    }

    @Override
    public Iterable<Home> findAllByCategoryHome(CategoryHome categoryHome) {
        return homeRepository.findAllByCategoryHome(categoryHome);
    }

    @Override
    public Iterable<Home> findAllByCategoryRoom(CategoryRoom categoryRoom) {
        return homeRepository.findAllByCategoryRoom(categoryRoom);
    }

    @Override
    public Iterable<Home> findAllByStatusHome(StatusHome statusHome) {
        return homeRepository.findAllByStatusHome(statusHome);
    }
}
