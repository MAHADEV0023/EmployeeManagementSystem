package com.Quess.EmployeeManagementSystem.Models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Entity

public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @Pattern(message="Only Characters Are Allowed But Special Characters And Digits Are Not Allowed", regexp = "^[a-zA-Z ]+$")
    private String name;



}
