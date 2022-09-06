package com.Quess.EmployeeManagementSystem.Service;



import com.Quess.EmployeeManagementSystem.Models.Employee;
import com.Quess.EmployeeManagementSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepository employeerepo;
    PasswordEncoder passwordEncoder;

    private Employee employee;

    public EmployeeServiceIMPL(EmployeeRepository employeerepo) {
        this.passwordEncoder=new BCryptPasswordEncoder();
        this.employeerepo =employeerepo;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        List<Employee> emp = employeerepo.findAll();
        boolean isFound = false;
        for (Employee e : emp) {
            if (e.getEmail().equals(employee.getEmail())) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return false;
        } else {
            String encodepass = this.passwordEncoder.encode(employee.getPassword());
            employee.setPassword(encodepass);
            employeerepo.save(employee);
            return true;
        }

    }


    @Override
    public List<Employee> getAllEmployee() {
        return employeerepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeerepo.findById(id).orElseThrow(() -> new  com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Employee not found with id :" + id));
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingDetail=employeerepo.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Employee not found with id :" + id));
       String encodepass=this.passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodepass);
        existingDetail.setEmployeename(employee.getEmployeename());
        existingDetail.setEmployeeage(employee.getEmployeeage());
        existingDetail.setEmployeecontact(employee.getEmployeecontact());
        existingDetail.setEmployeesalary(employee.getEmployeesalary());
        existingDetail.setEmployeegender(employee.getEmployeegender());
        existingDetail.setOrganizationid(employee.getOrganizationid());
        employeerepo.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteEmployeeById(int id) {
       Employee obj= employeerepo.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Employee not found with id :" + id));
       obj.getRoles().clear();
       employeerepo.deleteById(id);

    }



}
