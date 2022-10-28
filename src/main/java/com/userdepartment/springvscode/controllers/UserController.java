package com.userdepartment.springvscode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdepartment.springvscode.entities.User;
import com.userdepartment.springvscode.repositories.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping (value = "/users")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }
    //http://localhost:8080/users

    @GetMapping (value = "/{id}")
    public User findById(@PathVariable long id){
        User result = repository.findById(id).get();
        return result;
    }
    //http://localhost:8080/users/3

    @PostMapping
    public User insert(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }
    
}
