package com.example.exception.service;

import com.example.exception.exception.IntServErrException;
import com.example.exception.exception.NotFoundRuntimeException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    Employee[] employee = {
            new Employee("Иванов", "Иван"),
            new Employee("Петров", "Петр"),
            new Employee("Сидоров", "Сидор"),
    };
    @Override
    public Employee addEmployee(String lastName, String firstName) throws IntServErrException {  //throws - чтобы внутри этого метода не обрабатывалось исключение
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(lastName, firstName);
                return employee[i];
            }
        }
        throw new IntServErrException();
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) throws NotFoundRuntimeException {    //throws - чтобы внутри этого метода не обрабатывалось исключение
                  Employee removeEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(removeEmp)) {
                employee[i] = null;
                return removeEmp;
            }
        }  // если в массиве сотрудников[i].сотрудник отсутствует
            //то сотрудника нет
        //вернуть  переменную
        throw new NotFoundRuntimeException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws NotFoundRuntimeException {

        Employee findEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(findEmp)) {
                return findEmp;
            }
        }
        throw new NotFoundRuntimeException();
    }
}

