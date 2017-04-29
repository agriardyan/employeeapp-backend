package com.employeeapp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by trainee on 26/04/2017.
 */
@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "cityId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(name = "city", nullable = false)
    private String city;

//    @OneToMany(mappedBy = "city", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private Set<Employee> employees = new HashSet<>();

    public City() {
    }

//    public City(String city, Set<Employee> employees) {
//        this.city = city;
//        this.employees = employees;
//    }

    //    public City(String city, Set<Employee> employees) {
//        this.city = city;
//        this.employees = employees;
//    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
}
