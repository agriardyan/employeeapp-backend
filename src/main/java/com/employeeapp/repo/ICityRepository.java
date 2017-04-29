package com.employeeapp.repo;

import com.employeeapp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by trainee on 26/04/2017.
 */
public interface ICityRepository extends JpaRepository<City, Integer> {
}
