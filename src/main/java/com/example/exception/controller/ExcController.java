package com.example.exception.controller;

import com.example.exception.exception.ArrayOverflowException;
import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;
import com.example.exception.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class ExcController {
    private final EmployeeService employeeService;

    public ExcController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.addEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return "Сотрудник " + employeeService.removeEmployee(lastName, firstName) + " удален.";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }
}