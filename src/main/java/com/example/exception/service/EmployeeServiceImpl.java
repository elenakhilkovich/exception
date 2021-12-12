package com.example.exception.service;

import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeServiceImpl() {

        employeeMap.put("Сидоров Сидор Сидорович", new Employee("Сидоров", "Сидор", 1, 100000));
        employeeMap.put("Петров Петр Петрович", new Employee("Петров", "Петр", 2, 200000));
        employeeMap.put("Андреев Андрей Андреевич", new Employee("Андреев", "Андрей", 3, 300000));
        employeeMap.put("Антонов Антон Антонович", new Employee("Антонов", "Антон", 4, 400000));
        employeeMap.put("Васильев Василий Васильевич", new Employee("Васильев", "Василий", 5, 500000));
    }

        @Override
        public Employee addEmployee (String lastName, String firstName, int departmentId, int salary){
            Employee newEmployee = new Employee(lastName, firstName, departmentId, salary);

            employeeMap.put(lastName + " " + firstName, newEmployee);
            return employeeMap.get(lastName + " " + firstName);
        }
        @Override
        public Optional<Employee> getMaxSalary(int departmentId) {
            final Employee maxSalEmp;
            Optional<Employee> maxSal = employeeMap.values().stream().filter(e -> e.getDepartment() == departmentId).max(Comparator.comparingInt(e -> e.getSalary()));
            return maxSal;
        }

        @Override
        public Optional<Integer> getMinSalary(int departmentId) {
            Optional<Integer> minSal = employeeMap.values().stream().filter(e -> e.getDepartment() == departmentId).map(Employee::getSalary).min(Comparator.naturalOrder());
            return minSal;
        }

        @Override
        public List<Employee> printDepartmentEmployee(int departmentId) {
            List<Employee> all = employeeMap.values().stream().filter(e -> e.getDepartment() == departmentId).collect(Collectors.toList());
            return all;
        }

        @Override
        public Employee removeEmployee (String lastName, String firstName){
            if (employeeMap.containsKey(lastName + " " + firstName)) {
                return employeeMap.remove(lastName + " " + firstName);
            } else {
                throw new NotFoundException();
            }
        }

        @Override
        public Employee findEmployee (String lastName, String firstName){
            if (employeeMap.containsKey(lastName + " " + firstName)) {
                return employeeMap.get(lastName + " " + firstName);
            } else {
                throw new NotFoundException();
            }
        }
        @Override
        public Set<Employee> getEmployees(){
            return new HashSet<>(employeeMap.values());
        }


    }

