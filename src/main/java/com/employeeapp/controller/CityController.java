package com.employeeapp.controller;

import com.employeeapp.entity.City;
import com.employeeapp.repo.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by trainee on 26/04/2017.
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private ICityRepository cityRepository;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public List<City> fetchAll() {
        return cityRepository.findAll();
    }

}
