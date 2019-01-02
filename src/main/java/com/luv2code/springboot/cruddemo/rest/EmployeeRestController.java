package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();

    }

    @RequestMapping("/employee/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId){

        Employee employee =  employeeService.getEmployeeById(employeeId);

        if(employee == null){
            throw new  RuntimeException("there exist no such employee of id");
        }
        return employee;
    }


    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee == null){
            throw new RuntimeException("employee id not found");
        }
        employeeService.deleteById(employeeId);
        return "employee deleted with id >> " + employeeId;
    }
}
