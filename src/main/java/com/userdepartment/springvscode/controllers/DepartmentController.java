package com.userdepartment.springvscode.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.UnionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdepartment.springvscode.entities.Department;
import com.userdepartment.springvscode.entities.User;
import com.userdepartment.springvscode.repositories.DepartmentRepository;
import com.userdepartment.springvscode.repositories.UserRepository;

@RestController
@RequestMapping (value="/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Department> allDepartment(){
        List<Department> result = repository.findAll();
        return result;
    }
    
    @GetMapping (value = "/{id}")
    public Object findById(@PathVariable long id){
        Department department = repository.findById(id).get();
        User user = new User();
        user.setDepartment(department);
        Example<User> example = Example.of(user);
        List<User> users = userRepository.findAll(example);
        Map map = new HashMap<>();
        map.put("id", department.getId());
        map.put("name", department.getName());
        map.put("users", users);
        return map;
    }



}
