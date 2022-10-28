package com.userdepartment.springvscode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userdepartment.springvscode.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
