package com.example.exception.service;

import com.example.exception.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName, int departmentId, int salary);
    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);
    Optional<Employee> getMaxSalary(int departmentId);

    Optional<Integer> getMinSalary(int departmentId);

    List<Employee> printDepartmentEmployee(int departmentId);

    Set<Employee> getEmployees();
}
