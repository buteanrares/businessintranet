package com.BusinessIntranet.BusinessIntranet.Employee;

import com.BusinessIntranet.BusinessIntranet.Configuration.Configuration;
import com.BusinessIntranet.BusinessIntranet.Employee.DTOs.EmployeeDTO;
import com.BusinessIntranet.BusinessIntranet.Enums.EnumDepartment;
import com.BusinessIntranet.BusinessIntranet.Role.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(unique = true)
    private String email;
    @ElementCollection
    private Set<String> emailGroups;
    private String password;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String phone;
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private Department department;
    @ManyToOne
    private Employee manager;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String password, Set<String> emailGroups, String phone, String jobTitle, EnumDepartment department, Employee manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = firstName + "." + lastName + Configuration.EMAIL_DOMAIN;
        this.password = password;
        this.emailGroups = emailGroups;
        this.phone = phone;
        this.imageUrl = Configuration.INITIAL_IMAGE_URL;
        this.jobTitle = jobTitle;
        this.department = department;
        this.manager = manager;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(Set<String> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public EmployeeDTO toEmployeeDTO() {
        return new EmployeeDTO(
                this.id,
                this.firstName,
                this.lastName,
                this.phone,
                this.email,
                this.jobTitle
        );
    }
}
