package com.example.exception.controller;

import com.example.exception.exception.NotFoundRuntimeException;
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
    public String addEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.addEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return "Сотрудник " + employeeService.removeEmployee(lastName, firstName) + " удален.";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String lastName, @RequestParam String firstName) throws NotFoundRuntimeException {
        return employeeService.findEmployee(lastName, firstName).toString();
    }
}