package com.example.exception.service;

import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);

        employeeMap.put(lastName + " " + firstName, newEmployee);
        return employeeMap.get(lastName + " " + firstName);
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        if (employeeMap.containsKey(lastName + " " + firstName)) {
            return employeeMap.remove(lastName + " " + firstName);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (employeeMap.containsKey(lastName + " " + firstName)) {
            return employeeMap.get(lastName + " " + firstName);
        } else {
            throw new NotFoundException();
        }
    }
}

