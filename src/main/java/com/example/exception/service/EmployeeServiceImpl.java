package com.example.exception.service;

import com.example.exception.exception.EmployeeBadRequestException;
import com.example.exception.exception.EmployeeNotFoundException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();

        employeeMap.put("Сидоров Сидор", new Employee("Сидоров", "Сидор", 1, 100000));
        employeeMap.put("Петров Петр", new Employee("Петров", "Петр", 2, 200000));
        employeeMap.put("Андреев Андрей", new Employee("Андреев", "Андрей", 3, 300000));
        employeeMap.put("Антонов Антон", new Employee("Антонов", "Антон", 4, 400000));
        employeeMap.put("Васильев Василий", new Employee("Васильев", "Василий", 5, 500000));
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int departmentId, int salary) {
        Employee employeeNew = employeeMap.get(lastName + " " + firstName);
        if (employeeNew == null) {
            Employee newEmployee = new Employee(lastName, firstName, departmentId, salary);
            employeeMap.put(lastName + " " + firstName, newEmployee);
            return newEmployee;
        }
        throw new EmployeeBadRequestException();
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        if (employeeMap.containsKey(lastName + " " + firstName)) {
            Employee delEmployee = employeeMap.get(lastName + " " + firstName);
            employeeMap.remove(lastName + " " + firstName);
            return delEmployee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (!employeeMap.containsKey(lastName + " " + firstName)) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.get(lastName + " " + firstName);
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(employeeMap.values());
    }
}

