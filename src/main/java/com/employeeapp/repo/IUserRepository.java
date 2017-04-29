package com.employeeapp.repo;

import com.employeeapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by trainee on 28/04/2017.
 */
public interface IUserRepository extends JpaRepository<User, Integer> {

    public User findUserByUsername(@Param("username") String username);

    public User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
