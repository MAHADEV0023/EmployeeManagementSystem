package com.Quess.EmployeeManagementSystem.Repository;

import com.Quess.EmployeeManagementSystem.Models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
}
