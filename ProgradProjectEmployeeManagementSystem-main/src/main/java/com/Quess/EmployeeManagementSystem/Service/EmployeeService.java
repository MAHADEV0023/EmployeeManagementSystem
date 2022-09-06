package com.Quess.EmployeeManagementSystem.Service;

import com.Quess.EmployeeManagementSystem.Models.Employee;

import java.util.List;

public interface EmployeeService {

    public boolean saveEmployee(Employee employee);

    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployeeById(int id);

    }
