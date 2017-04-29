package com.employeeapp.controller;

import com.employeeapp.entity.User;
import com.employeeapp.repo.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by trainee on 28/04/2017.
 */
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Autowired
    private IUserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User index(@RequestBody User user) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());

        if(userByUsername != null) {
            User userByUsernameAndPassword = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
            if(userByUsernameAndPassword != null) {
                return userByUsernameAndPassword;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
