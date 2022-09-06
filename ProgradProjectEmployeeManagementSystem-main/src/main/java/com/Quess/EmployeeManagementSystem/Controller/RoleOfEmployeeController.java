package com.Quess.EmployeeManagementSystem.Controller;



import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;
import com.Quess.EmployeeManagementSystem.Service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeerole")
public class RoleOfEmployeeController {
    @Autowired
    private EmployeeRoleService employeeroleservice;

    public RoleOfEmployeeController(EmployeeRoleService service) {
        this.employeeroleservice = service;
    }

    @PostMapping
    public ResponseEntity<String> saveRoleOfEmployee(@RequestBody @Valid EmployeeRole roleOfEmployee)
    {
        employeeroleservice.saveRoleOfEmployee(roleOfEmployee);
        return new ResponseEntity<String>("Rol Created successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeRole> getAllRoleOfEmployee()

    {
        return employeeroleservice.getAllRoleOfEmployee();
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeRole> getRoleOfEmployeeById(@PathVariable("id")int id)
    {
        return new ResponseEntity<EmployeeRole>(employeeroleservice.getRoleOfEmployeeById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateRoleOfEmployee(@PathVariable("id")int id,@RequestBody @Valid EmployeeRole roleOfEmployee)
    {
        employeeroleservice.updateRoleOfEmployee(roleOfEmployee,id);
        return new ResponseEntity<String>("Role Updated Successfully", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoleOfEmployee(@PathVariable("id")int id)
    {
        employeeroleservice.deleteRoleOfEmployee(id);
        return new ResponseEntity<String>("Role deleted successfully",HttpStatus.OK);
    }
}
