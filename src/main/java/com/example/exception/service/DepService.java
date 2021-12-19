package com.example.exception.service;

import com.example.exception.model.Employee;

import java.util.List;

public interface DepService {
    Employee getMaxSalary(int departmentId);

    Employee getMinSalary(int departmentId);

    List<Employee> printDepartmentEmployee(int departmentId);

    List<Employee> printDepartmentEmployee();
}
