package com.employeeapp.repo;

import com.employeeapp.entity.City;
import com.employeeapp.entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by trainee on 21/04/2017.
 */
@RestResource(exported = true)
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findEmployeesByLastNameContainsOrFirstNameContainsAllIgnoreCase(@Param("lastName") String lastName, @Param("firstName") String firstName);

    public List<Employee> findEmployeeByCity(@Param("city") City city);

    public List<Employee> findEmployeeByGender(@Param("gender") String gender);

}
