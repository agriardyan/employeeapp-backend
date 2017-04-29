package com.employeeapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

/**
 * Created by trainee on 21/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    private String jsonSuccessAdd = "";

    @Autowired
    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();


    }

    @Test
    public void fetchAll() throws Exception {
        String response = this.mockMvc.perform(get("/employee/fetch")).andReturn().getResponse().getContentAsString();
        System.out.println("response: " + response);
        assertNotNull("response", response);
    }

//    @Test
//    public void addEmployee() throws Exception {
////        employeeController = mock(EmployeeController.class);
//
//        this.mockMvc.perform(post("/employee/add")
//            .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk());
//    }

}