package com.springstudy.employeedirectory.dao;

import com.springstudy.employeedirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // nothing to write

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
