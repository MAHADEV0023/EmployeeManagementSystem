package com.Quess.EmployeeManagementSystem.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "Assets")
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty(message = "You need to fill assetName")
    @Pattern(message="Only Characters Are Allowed But Special Characters And Digits Are Not Allowed", regexp = "^[a-zA-Z ]+$")
    private String assetName;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(message="Only Characters Are Allowed But Special Characters And Digits Are Not Allowed", regexp = "^[a-zA-Z ]+$")
    private String assetType;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(message="Only Digits Are Allowed And Negetive Values Are Not Allowed", regexp = "^[0-9]+$")
    private String assetcost;
    @Column(nullable = true)
    private int organizationid;

}
