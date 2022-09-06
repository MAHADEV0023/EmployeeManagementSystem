package com.Quess.EmployeeManagementSystem.Service;

import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;


import java.util.List;

public interface EmployeeRoleService {

    EmployeeRole saveRoleOfEmployee(EmployeeRole roleOfEmployee);

    List<EmployeeRole> getAllRoleOfEmployee();
    EmployeeRole getRoleOfEmployeeById(int id);
    EmployeeRole updateRoleOfEmployee(EmployeeRole roleOfEmployee,int id);
    void deleteRoleOfEmployee(int id);
}
