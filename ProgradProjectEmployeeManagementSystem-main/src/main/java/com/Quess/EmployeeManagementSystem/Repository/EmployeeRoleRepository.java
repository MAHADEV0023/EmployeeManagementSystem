package com.Quess.EmployeeManagementSystem.Repository;

import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole,Integer> {



}
