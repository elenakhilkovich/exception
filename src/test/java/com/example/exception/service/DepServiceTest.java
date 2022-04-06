package com.example.exception.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.exception.data.EmployeeData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepServiceTest {

    @Mock
    private final EmployeeService employeeServiceMock = mock(EmployeeService.class);


    @InjectMocks
    private DepServiceImpl out;

    @Test
    public void shouldReturnAllEmployeesWhenEmployeesSetExist() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);
        assertIterableEquals(TEST_SORTED_LIST_EMPLOYEE, out.getDepEmployee());
    }

    @Test
    public void shouldReturnEmptySetWhenEmployeesSetNotExist() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertIterableEquals(TEST_EMPTY_SET_EMPLOYEE, out.getDepEmployee());
    }

    @Test
    public void shouldReturnAllEmployeesInDepartment() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertIterableEquals(TEST_SORTED_DEPART_LIST_EMPLOYEE, out.getDepEmployee(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmptySetInDepartmentWhenSetIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertIterableEquals(TEST_EMPTY_SET_EMPLOYEE, out.getDepEmployee(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnMaxSalaryEmployee() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(EMPLOYEE_3, out.getMaxSalary(DEPARTMENT_ID1).get());
    }


    @Test
    public void shouldReturnEmptyMaxSalaryEmployeeWhenDepartmentIncorrect() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnEmptyMaxSalaryEmployeeWhenSetIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnMinSalaryEmployee() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(EMPLOYEE_4, out.getMinSalary(DEPARTMENT_ID1).get());
    }


    @Test
    public void shouldReturnEmptyMinSalaryEmployeeWhenDepartmentIncorrect() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnEmptyMinSalaryEmployeeWhenSetIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }
}
