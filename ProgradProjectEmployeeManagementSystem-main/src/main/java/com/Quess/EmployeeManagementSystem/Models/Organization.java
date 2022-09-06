package com.Quess.EmployeeManagementSystem.Models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "Organization")
public class Organization  {

    public Organization() {

    }
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty(message="You need To fill Organization Name")
    @Pattern(message="Only Characters Are Allowed But Special Characters And Digits Are Not Allowed", regexp = "^[a-zA-Z ]+$")
    private String organizationname;
    @Column(nullable = false)
    @NotEmpty(message="Address Field Should Not Be Empty")
    private String  organizationaddress;



@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
@JoinColumn(name = "organizationid",referencedColumnName = "id")
private Set<Assets> assets = new HashSet<>();

@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
@JoinColumn(name = "organizationid",referencedColumnName = "id")
private Set<Employee> employees = new HashSet<>();

}
