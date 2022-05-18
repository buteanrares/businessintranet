package com.BusinessIntranet.BusinessIntranet.Employee;

import com.BusinessIntranet.BusinessIntranet.Enums.EnumDepartment;
import com.BusinessIntranet.BusinessIntranet.Enums.EnumPermission;
import com.BusinessIntranet.BusinessIntranet.Enums.EnumRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


@Entity(name = "Employees")
public class Employee implements Serializable{
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
    @ManyToOne
    private Employee manager;
    @Enumerated(EnumType.STRING)
    private EnumDepartment department;
    @ElementCollection
    private Set<String> roles;
    @ElementCollection
    private Set<String> permissions;

    public Employee() {
    }

    public Employee(String email, Set<String> emailGroups, String password, String firstName, String lastName, String imageUrl, String phone, String jobTitle, EnumDepartment department, Employee manager) {
        this.email = email;
        this.emailGroups = emailGroups;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.phone = phone;
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

    public EnumDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EnumDepartment enumDepartment) {
        this.department = enumDepartment;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
