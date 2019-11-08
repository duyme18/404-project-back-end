package com.hotel.service;

import com.hotel.model.StatusHome;

public interface StatusHomeService {

    Iterable<StatusHome> findAll();

    StatusHome findById(Long id);

    void remove(Long id);

    void save(StatusHome statusHome);
}
