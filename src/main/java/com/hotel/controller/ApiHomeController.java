package com.hotel.controller;

import com.hotel.model.Home;
import com.hotel.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
public class ApiHomeController {
    @Autowired
    private HomeService homeService;
    //-------------------Retrieve All Categories----------------------------------------------------

    @RequestMapping(value = "/api/home", method = RequestMethod.GET)
    public ResponseEntity<List<Home>> listHomes() {
        List<Home> homes = (List<Home>) homeService.findAll();
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    //-------------------Retrieve Single category--------------------------------------------------------

    @RequestMapping(value = "/api/home/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Home> getHome(@PathVariable("id") long id) {
        System.out.println("Fetching Home with id " + id);
        Home home = homeService.findById(id);
        if (home == null) {
            System.out.println("Home with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(home, HttpStatus.OK);
    }

    //-------------------Create a category--------------------------------------------------------

    @RequestMapping(value = "/api/home", method = RequestMethod.POST)
    public ResponseEntity<Void> createHome(@RequestBody Home home, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Home " + home.getName());
        homeService.save(home);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/home/{id}").buildAndExpand(home.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a category --------------------------------------------------------

    @RequestMapping(value = "/api/home/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Home> updateCategory(@PathVariable("id") long id, @RequestBody Home home) {
        System.out.println("Updating Home " + id);

        Home currentHome = homeService.findById(id);

        if (currentHome == null) {
            System.out.println("Home with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentHome.setCategoryRoom(home.getCategoryRoom());
        currentHome.setCategoryHome(home.getCategoryHome());
        currentHome.setStatusHome(home.getStatusHome());
        currentHome.setDescription(home.getDescription());
        currentHome.setPrice(home.getPrice());
        currentHome.setBathroomQuantity(home.getBathroomQuantity());
        currentHome.setBedroomQuantity(home.getBedroomQuantity());
        currentHome.setAddress(home.getAddress());
        currentHome.setName(home.getName());
        currentHome.setId(home.getId());

        homeService.save(currentHome);
        return new ResponseEntity<>(currentHome, HttpStatus.OK);
    }

    //------------------- Delete a Category --------------------------------------------------------

    @RequestMapping(value = "/api/home/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Home> deleteHome(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Home with id " + id);

        Home home = homeService.findById(id);
        if (home == null) {
            System.out.println("Unable to delete. Home with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        homeService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
