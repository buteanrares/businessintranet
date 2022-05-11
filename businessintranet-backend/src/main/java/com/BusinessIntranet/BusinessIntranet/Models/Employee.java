package com.BusinessIntranet.BusinessIntranet.Models;

import com.BusinessIntranet.BusinessIntranet.Configuration.Configuration;
import com.BusinessIntranet.BusinessIntranet.Enums.Department;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "Employees")
public class Employee {
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

    public Employee(String email, Set<String> emailGroups, String firstName, String lastName, String phone, String jobTitle, Department department, Employee manager) {
        this.email = email;
        this.emailGroups = emailGroups;
        this.password = Configuration.INITIAL_PASSWORD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = Configuration.INITIAL_IMAGE_URL;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.department = department;
        this.manager=manager;
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
}
