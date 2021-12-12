package com.example.exception.service;
import com.example.exception.model.Employee;

import java.util.List;
import java.util.Optional;

    public interface DepService {
        Optional<Employee> getMaxSalary(int departmentId);

        Optional<Employee> getMinSalary(int departmentId);

        List<Employee> printDepartmentEmployee(int departmentId);

        List<Employee> printDepartmentEmployee();
    }
