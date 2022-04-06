package com.example.exception.data;
import com.example.exception.model.Employee;

import java.util.*;
public class EmployeeData {

    public static final String FIRST_NAME_ADD = "Кирилл";
    public static final String LAST_NAME_ADD = "Кириллов";
    public static final String FIRST_NAME_DEL = "Семен";
    public static final String LAST_NAME_DEL = "Семенов";
    public static final String FIRST_NAME_FIND = "Максим";
    public static final String LAST_NAME_FIND = "Максимов";
    public static final int SALARY1 = 500;
    public static final int DEPARTMENT_ID1 = 2;
    public static final int DEPARTMENT_ID_INCORRECT = 0;
    public static final Employee EMPLOYEE_ADD =  new Employee(LAST_NAME_ADD, FIRST_NAME_ADD, DEPARTMENT_ID1, SALARY1);
    public static final Employee EMPLOYEE_DEL =  new Employee(LAST_NAME_DEL, FIRST_NAME_DEL, DEPARTMENT_ID1, SALARY1);
    public static final Employee EMPLOYEE_FIND =  new Employee(LAST_NAME_FIND, FIRST_NAME_FIND, DEPARTMENT_ID1, SALARY1);
    public static final Employee EMPLOYEE_1 = new Employee("Михайлов", "Михаил", 3, 1900);
    public static final Employee EMPLOYEE_2 = new Employee("Дмитриев", "Дмитрий", 1, 1500);
    public static final Employee EMPLOYEE_3 = new Employee("Степанов", "Степан", 2, 2000);
    public static final Employee EMPLOYEE_4 = new Employee("Николаев", "Николай", 2, 1000);
    public static final Set<Employee> TEST_SET_EMPLOYEE = new HashSet<>(Set.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3,EMPLOYEE_4));
    public static final Set<Employee> TEST_EMPTY_SET_EMPLOYEE = new HashSet<>();
    public static final List<Employee> TEST_SORTED_LIST_EMPLOYEE = new ArrayList<>(List.of(EMPLOYEE_2, EMPLOYEE_3, EMPLOYEE_1));
    public static final List<Employee> TEST_SORTED_DEPART_LIST_EMPLOYEE = new ArrayList<>(List.of(EMPLOYEE_3));



}
