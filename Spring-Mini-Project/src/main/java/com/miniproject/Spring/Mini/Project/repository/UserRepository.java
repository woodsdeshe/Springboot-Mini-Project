package com.miniproject.Spring.Mini.Project.repository;

import com.miniproject.Spring.Mini.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //find user by email address (login)
    User findUserByEmailAddress(String emailAddress);

    // see if user exists by email
    boolean existsByEmailAddress(String emailAddress);

}
