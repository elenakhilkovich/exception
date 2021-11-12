package com.example.exception.service;

import com.example.exception.exception.IntServErrException;
import com.example.exception.exception.NotFoundRuntimeException;
import com.example.exception.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName) throws IntServErrException;
    Employee removeEmployee(String lastName, String firstName) throws NotFoundRuntimeException;

    Employee findEmployee(String lastName, String firstName) throws NotFoundRuntimeException;
}
