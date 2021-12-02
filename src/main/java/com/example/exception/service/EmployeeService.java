package com.example.exception.service;

import com.example.exception.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);
}
