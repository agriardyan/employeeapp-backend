package com.employeeapp.controller;

import com.employeeapp.entity.City;
import com.employeeapp.entity.Employee;
import com.employeeapp.entity.User;
import com.employeeapp.repo.ICityRepository;
import com.employeeapp.repo.IEmployeeRepository;
import com.employeeapp.repo.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

/**
 * Created by root on 4/29/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = {LoginController.class})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class LoginControllerTest {

    @Autowired
    @Qualifier("loginController")
    private LoginController loginController;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ICityRepository cityRepository;

    private String username;
    private String password;
    private Employee employee;
    private User user;

    @Before
    public void setUp() throws Exception {

//        String jsonObj = "{\"empId\": 1,\"firstName\": \"John\",\"lastName\": \"James\",\"gender\": \"Male\",\"dateOfBirth\": \"1992-10-15\",\"nationality\": \"Indonesian\",\"maritalStatus\": \"Single\",\"phone\": \"+62872847892301\",\"city\": {\"cityId\": 1,\"city\": \"Yogyakarta\"},\"subDivision\": \"Java Bootcamp\",\"status\": \"Contract\",\"suspendDate\": null,\"hiredDate\": \"2010-11-12\",\"grade\": \"SE - AN\",\"division\": \"CDC\",\"email\": \"jjames@gmail.com\",\"profilePicture\": \"\"}";

//        Employee e = objectMapper.readValue(jsonObj, Employee.class);

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

        employeeRepository.saveAndFlush(e);

        User u = new User();
        u.setUsername("jack");
        u.setPassword("jack");
        u.setEmpId(e);

        User user = userRepository.saveAndFlush(u);

        this.username = user.getUsername();
        this.password = user.getPassword();
        this.employee = user.getEmpId();
        this.user = user;

        assertNotNull(user.getEmpId());

    }

    @Test
    public void index() throws Exception {

        given()
                .contentType(ContentType.JSON)
                .body(this.user)
                .standaloneSetup(this.loginController)
                .when()
                .post("/auth/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("username", equalTo(this.username))
                .body("password", equalTo(this.password))
                .body("empId.firstName", equalTo(this.employee.getFirstName()));


        given()
                .contentType(ContentType.JSON)
                .body(this.user)
                .standaloneSetup(this.loginController)
                .when()
                .post("/auth/auth")
                .then()
                .statusCode(404);

//        given()
//                .standaloneSetup(this.loginController)
//                .accept(ContentType.JSON)
//                .when()
//                .post("/auth/", this.user)
//                .then()
//                .statusCode(200)
//                .body("username", hasItems(this.username))
//                .body("password", hasItems(this.password));
    }

    @After
    public void tearDown()
    {
        userRepository.deleteAll();
        this.username = null;
        this.password = null;
        this.employee = null;

    }

}