package com.example.exception.service;

import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepServiceImpl implements DepService {

    private final EmployeeService employeeService;

    public DepServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> getMaxSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getMinSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public List<Employee> getDepEmployee(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getDepEmployee() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment)
                        .thenComparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }
}
