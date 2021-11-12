package com.example.exception.service;

import com.example.exception.exception.IntServErrException;
import com.example.exception.exception.NotFoundRuntimeException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ArrayList<Employee> employee = new ArrayList<>();

    @Override
    public String addEmployee(String lastName, String firstName) throws IntServErrException {
        Employee newEmployee = new Employee(lastName, firstName);
        if (employee.size() < 3) {
            employee.add(newEmployee);
            return "Сотрудник " + newEmployee + " добавлен.";
        } else {
            throw new IntServErrException();
        }
    }

    @Override
    public String removeEmployee(String lastName, String firstName) throws NotFoundRuntimeException {
        Employee removeEmployee = new Employee(lastName, firstName);
        if (employee.contains(removeEmployee)) {
            employee.remove(removeEmployee);
            return "Сотрудник " + removeEmployee + " удален.";
        } else {
            throw new NotFoundRuntimeException();
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws NotFoundRuntimeException {

        Employee findEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).equals(findEmp)) {
                return employee.get(i);
            }
        }
        throw new NotFoundRuntimeException();
    }
}

