package com.userdepartment.springvscode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userdepartment.springvscode.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
