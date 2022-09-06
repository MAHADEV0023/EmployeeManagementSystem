package com.Quess.EmployeeManagementSystem.Service;


import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;

import com.Quess.EmployeeManagementSystem.Repository.EmployeeRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRoleServiceIMPL implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    public EmployeeRoleServiceIMPL(EmployeeRoleRepository employeeRoleRepository) {
        this.employeeRoleRepository = employeeRoleRepository;
    }

    @Override
    public EmployeeRole saveRoleOfEmployee(EmployeeRole roleOfEmployee) {
        return employeeRoleRepository.save(roleOfEmployee);
    }

    @Override
    public List<EmployeeRole> getAllRoleOfEmployee() {
        return employeeRoleRepository.findAll();
    }

    @Override
    public EmployeeRole getRoleOfEmployeeById(int id) {
        return employeeRoleRepository.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Role not found with id :" + id));
    }

    @Override
    public EmployeeRole updateRoleOfEmployee(EmployeeRole roleOfEmployee, int id) {
        EmployeeRole existingDetail= employeeRoleRepository.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Role not found with id :" + id));
        existingDetail.setEmployeeid(roleOfEmployee.getEmployeeid());
        existingDetail.setRoleid(roleOfEmployee.getRoleid());
        employeeRoleRepository.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteRoleOfEmployee(int id) {
        employeeRoleRepository.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Role not found with id :" + id));
        employeeRoleRepository.deleteById(id);


    }

}
