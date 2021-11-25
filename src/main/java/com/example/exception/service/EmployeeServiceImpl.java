package com.example.exception.service;

import com.example.exception.exception.ArrayOverflowException;
import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ArrayList<Employee> employee = new ArrayList<>();

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);//throws - чтобы внутри этого метода не обрабатывалось исключение
        if (employee.size() < 3) {
            employee.add(newEmployee);
            return newEmployee;
        } else {
            throw new ArrayOverflowException();
        }
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName)  {    //throws - чтобы внутри этого метода не обрабатывалось исключение
        Employee removeEmployee = new Employee(lastName, firstName);
        if (employee.contains(removeEmployee)) {
            employee.remove(removeEmployee);
            return removeEmployee;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName)  {

        Employee findEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).equals(findEmp)) {
                return employee.get(i);
            }
        }
        throw new NotFoundException();
    }
}

