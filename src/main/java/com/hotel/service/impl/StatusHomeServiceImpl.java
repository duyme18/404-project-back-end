package com.hotel.service.impl;

import com.hotel.model.StatusHome;
import com.hotel.repository.StatusHomeRepository;
import com.hotel.service.StatusHomeService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusHomeServiceImpl implements StatusHomeService {
    @Autowired
    private StatusHomeRepository statusHomeRepository;

    @Override
    public Iterable<StatusHome> findAll() {
        return statusHomeRepository.findAll();
    }

    @Override
    public StatusHome findById(Long id) {
        return statusHomeRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        statusHomeRepository.delete(id);
    }

    @Override
    public void save(StatusHome statusHome) {
        statusHomeRepository.save(statusHome);
    }
}
