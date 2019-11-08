package com.hotel.controller;

import com.hotel.model.StatusHome;
import com.hotel.service.StatusHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ApiStatusHome {
    @Autowired
    private StatusHomeService statusHomeService;

    @GetMapping("/api/status")
    public ResponseEntity<List<StatusHome>> getStatusList() {
        List<StatusHome> statuses = (List<StatusHome>) statusHomeService.findAll();

        if (statuses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @GetMapping("/api/status/{id}")
    public ResponseEntity<StatusHome> getStatus(@PathVariable Long id) {
        StatusHome status = statusHomeService.findById(id);

        if (status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/api/status")
    public ResponseEntity<Void> createStatus(@RequestBody StatusHome status) {
        statusHomeService.save(status);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/status/{id}")
    public ResponseEntity<StatusHome> editStatus(@RequestBody StatusHome status, @PathVariable Long id) {
        StatusHome status1 = statusHomeService.findById(id);
        if (status1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        status1.setName(status.getName());
        statusHomeService.save(status1);

        return new ResponseEntity<>(status1, HttpStatus.OK);
    }

    @DeleteMapping("/api/status/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        StatusHome status = statusHomeService.findById(id);

        if (status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        statusHomeService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}