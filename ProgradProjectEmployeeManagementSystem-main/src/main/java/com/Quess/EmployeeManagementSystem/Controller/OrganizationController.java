package com.Quess.EmployeeManagementSystem.Controller;
import com.Quess.EmployeeManagementSystem.Models.Organization;
import com.Quess.EmployeeManagementSystem.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationservice;

    public OrganizationController(OrganizationService service) {
        this.organizationservice = service;
    }
    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody @Valid Organization organization)
    {
        return new ResponseEntity<Organization>(organizationservice.saveOrganization(organization), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Organization> getAllOrganization()

    {
        return organizationservice.getAllOrganization();
    }
    @GetMapping("{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Organization>(organizationservice.getOrganizationById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateOrganization(@PathVariable("id")int id,@RequestBody @Valid Organization organization)
    {
        organizationservice.updateOrganization(organization,id);
        return new ResponseEntity<String>("Organization Updated Successfully", HttpStatus.OK);
    }
    @DeleteMapping("{organization_id}")
    public ResponseEntity<String> deleteOrganizationById(@PathVariable("organization_id")int organization_id)
    {
        organizationservice.deleteOrganizationid(organization_id);
        return new ResponseEntity<String>("Organization Detail Deleted Successfully",HttpStatus.OK);
    }
}

