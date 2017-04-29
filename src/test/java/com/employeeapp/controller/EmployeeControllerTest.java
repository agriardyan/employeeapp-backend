package com.employeeapp.controller;

import com.employeeapp.entity.City;
import com.employeeapp.entity.Employee;
import com.employeeapp.repo.ICityRepository;
import com.employeeapp.repo.IEmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

/**
 * Created by trainee on 21/04/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = {EmployeeController.class})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeControllerTest {

//    private String jsonSuccessAdd = "";

    @Autowired
    @Qualifier("employeeController")
    private EmployeeController employeeController;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ICityRepository cityRepository;

    private String username;
    private String password;
    private Employee employee;

//    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

        City ct = new City();
        ct.setCityId(1);
        ct.setCity("Yogyakarta");

        cityRepository.saveAndFlush(ct);

        Employee e = new Employee();
        e.setCity(ct);
        e.setDateOfBirth(new Date());
        e.setDivision("Div");
        e.setEmail("mail@mail.com");
        e.setFirstName("John");
        e.setGender("Male");
        e.setGrade("JP");
        e.setHiredDate(new Date());
        e.setLastName("Last Nam");
        e.setMaritalStatus("Single");
        e.setNationality("Korean");
        e.setStatus("Contract");
        e.setSubDivision("Java Bootcamp");
        e.setPhone("123456");
        e.setEmpId(1);
        e.setProfilePicture("");
        e.setSuspendDate(null);

        this.employee = employeeRepository.saveAndFlush(e);

        assertNotNull(this.employee);
    }

    @Test
    public void fetchAll() throws Exception {
//        String response = this.mockMvc.perform(get("/employee/fetch")).andReturn().getResponse().getContentAsString();
//        System.out.println("response: " + response);
//        assertNotNull("response", response);
        ObjectMapper objectMapper = new ObjectMapper();

        given()
                .contentType(ContentType.JSON)
                .standaloneSetup(this.employeeController)
                .when()
                .get("/employee/fetch/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat(mvcResult -> {
                    Employee[] emp = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Employee[].class);
                    System.err.println(emp.length);
                    System.err.println(emp[0].getFirstName());
                    System.err.println(this.employee.getFirstName());
                    assertEquals(emp[0].getFirstName(), this.employee.getFirstName());
//                    assertTrue(emp[0].equals(this.employee));
                });


    }

}