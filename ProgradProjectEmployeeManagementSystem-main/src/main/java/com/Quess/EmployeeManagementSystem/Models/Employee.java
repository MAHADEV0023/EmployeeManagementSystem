package com.Quess.EmployeeManagementSystem.Models;



import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="Employee")
public class Employee implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty(message = "You Need To Fill The Name Field")
    @Pattern(message="Only Characters Are Allowed But Special Characters And Digits Are Not Allowed", regexp = "^[a-zA-Z ]+$")
    private String employeename;
    @Column(nullable = false)
    @NotNull(message = "Fill The Age Don't leave Empty")
    @Min(value = 22,message = "Your Age Should Be Between 22 To 58")
    @Max(value = 58,message = "Your Age SHould Be Between 22 To 58")
    private int employeeage;
    @Column(nullable = false)
    @NotEmpty(message = "fill proper phone number ")
    @Pattern(message="Phone Number Is Not Valid", regexp = "^[0-9]{10}$")
    private String employeecontact;
    @Column(nullable = false)
    @Min(value = 10000,message = "Salary Shoulde Be Minimum 10000 And It Should Not Be Negative Value")
    private String employeesalary;
    @Column(nullable = false)
    @NotEmpty(message = "fill proper email ")
    @Email(message = "Email Is Not In Proper Structure", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    @Column(nullable = false)
    private String employeegender;
    @Column(nullable = true)
    private int organizationid;

    @Column(nullable = false)
    @Pattern(message="password must contain atleast contain 1 uppercase, 1 lowercase, 1 special character and 1 digit with atleast 8 characters",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;

   @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinTable(name="EmployeeRole", joinColumns = @JoinColumn(name="employeeid", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="roleid",referencedColumnName = "id"))
    private Set<Role> roles=new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities=this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return  authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
