package com.employeeapp.controller;

import com.employeeapp.entity.City;
import com.employeeapp.entity.Employee;
import com.employeeapp.repo.ICityRepository;
import com.employeeapp.repo.IEmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by trainee on 21/04/2017.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ICityRepository cityRepository;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public List<Employee> fetchAll() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    public Employee fetch(@PathVariable int id) {
        return employeeRepository.findOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Employee> search(@RequestParam String name) {
        if(name.isEmpty()) {
            return employeeRepository.findAll();
        } else {
            return employeeRepository.findEmployeesByLastNameContainsOrFirstNameContainsAllIgnoreCase(name, name);
        }
    }

    @RequestMapping(value = "/filtercity", method = RequestMethod.GET)
    public List<Employee> filterByCity(@RequestParam int city) {
        return employeeRepository.findEmployeeByCity(cityRepository.findOne(city));
    }

    @RequestMapping(value = "/filtergender", method = RequestMethod.GET)
    public List<Employee> filterByGender(@RequestParam String gender) {
        return employeeRepository.findEmployeeByGender(gender);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee e) {
//        ObjectMapper objectMapper = springMvcJacksonConverter.getObjectMapper();
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        employeeRepository.saveAndFlush(e);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateEmployee(@RequestBody Employee e) {
        employeeRepository.saveAndFlush(e);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Employee e) {
        employeeRepository.delete(e);
    }
}
