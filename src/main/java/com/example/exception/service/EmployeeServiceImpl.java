package com.example.exception.service;

import com.example.exception.exception.ArrayOverflowException;
import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employee = new ArrayList<>();   //убрала ArraysList

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);

        employee.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employeeToRemove = new Employee(lastName, firstName);
        if (employee.contains(employeeToRemove)) {
            employee.remove(employeeToRemove);
            return employeeToRemove;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {

        Employee employeeToFind = new Employee(lastName, firstName);
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).equals(employeeToFind)) {
                return employeeToFind;
            }
        }
        throw new NotFoundException();
    }
}

