package com.example.exception.controller;

import com.example.exception.model.Employee;
import com.example.exception.service.DepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/department")
@RestController

public class DepartController {
    private final DepService depService;

    public DepartController(DepService depService) {
        this.depService = depService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int departmentId) {
        return depService.getMaxSalary(departmentId).orElseThrow();
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int departmentId) {
        return depService.getMinSalary(departmentId)
                .orElseThrow();
    }

    @GetMapping("/all")
    public List<Employee> printDepartmentEmployee(Integer departmentId) {
        if (departmentId == null) {
            return depService.printDepartmentEmployee();
        } else {
            return depService.printDepartmentEmployee(departmentId);
        }
    }
}

