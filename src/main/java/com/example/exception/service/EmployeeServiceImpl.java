package com.example.exception.service;

import com.example.exception.exception.ArrayOverflowException;
import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    Employee[] employee = new Employee[3];
    @Override
    public Employee addEmployee(String lastName, String firstName) throws ArrayOverflowException {  //throws - чтобы внутри этого метода не обрабатывалось исключение
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(lastName, firstName);
                return employee[i];
            }
        }
        throw new ArrayOverflowException();
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) throws NotFoundException {    //throws - чтобы внутри этого метода не обрабатывалось исключение
                  Employee removeEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(removeEmp)) {
                employee[i] = null;
                return removeEmp;
            }
        }  // если в массиве сотрудников[i].сотрудник отсутствует
            //то сотрудника нет
        //вернуть  переменную
        throw new NotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws NotFoundException {

        Employee findEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(findEmp)) {
                return findEmp;
            }
        }
        throw new NotFoundException();
    }
}

