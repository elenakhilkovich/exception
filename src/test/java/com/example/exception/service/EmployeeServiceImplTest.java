package com.example.exception.service;
import com.example.exception.exception.EmployeeNotFoundException;
import com.example.exception.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.exception.data.EmployeeData.*;


public class EmployeeServiceImplTest {


    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnEmployeeDenyWhenAddEmployeeDeny() {
        Employee result = out.addEmployee(LAST_NAME_ADD, FIRST_NAME_ADD, DEPARTMENT_ID1, SALARY1);
        Assertions.assertEquals(result, EMPLOYEE_ADD);
    }
    @Test
    public void shouldReturnRemovedEmployeeWhenRemoveEmployee() {
        out.addEmployee(LAST_NAME_DEL, FIRST_NAME_DEL, DEPARTMENT_ID1, SALARY1);
        Employee result = out.removeEmployee(LAST_NAME_DEL, FIRST_NAME_DEL);
        Assertions.assertEquals(result, EMPLOYEE_DEL);
    }
    @Test
    public void shouldReturnEmpNotFoundExceptionWhenEmployeeNotFound() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(LAST_NAME_ADD, FIRST_NAME_ADD));
    }
}
