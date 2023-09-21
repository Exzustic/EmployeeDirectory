package com.springstudy.employeedirectory.service;

import com.springstudy.employeedirectory.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
