package com.Quess.EmployeeManagementSystem.Controller;


import com.Quess.EmployeeManagementSystem.Models.Employee;
import com.Quess.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.Quess.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService service) {
        this.employeeservice = service;
    }

    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid Employee employee)
    {
        if(employeeservice.saveEmployee(employee))
            return new ResponseEntity<String>("Employee Got Created Successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<String>("Email Alredy Exists", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public List<Employee> getAllEmployee()
    {
        return employeeservice.getAllEmployee();
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id)
    {
            return new ResponseEntity<Employee>(employeeservice.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getEmployeeByIde(@PathVariable("id")int id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userID = employeeRepository.findByEmail(authentication.getName()).get().getId();
        if (userID != id && authentication.getAuthorities().contains(new SimpleGrantedAuthority("EMPLOYEE")))
        {
            return new ResponseEntity<String>("Unauthorized Access Please Provide Correct UserName And Passowrd", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Employee>(employeeservice.getEmployeeById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id")int id,@RequestBody @Valid Employee employee)
    {
        employeeservice.updateEmployee(employee,id);
        return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id")int id)
    {

        employeeservice.deleteEmployeeById(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
}
