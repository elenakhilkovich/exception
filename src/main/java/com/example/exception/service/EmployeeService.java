package com.example.exception.service;

import com.example.exception.exception.ArrayOverflowException;
import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName) throws ArrayOverflowException;
    Employee removeEmployee(String lastName, String firstName) throws NotFoundException;

    Employee findEmployee(String lastName, String firstName) throws NotFoundException;
}
