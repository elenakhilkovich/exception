package com.example.exception.service;

import com.example.exception.exception.EmployeeNotFoundException;
import com.example.exception.model.Employee;

import java.util.Set;

public interface EmployeeService {

    Employee addEmployee(String lastName, String firstName, int departmentId, int salary);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Set<Employee> getEmployees();
}
