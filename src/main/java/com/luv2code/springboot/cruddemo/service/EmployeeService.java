package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee getEmployeeById(int Id);

    public void save(Employee employee);

    public void deleteById(int Id);
}
