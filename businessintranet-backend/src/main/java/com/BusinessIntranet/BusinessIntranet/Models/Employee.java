package com.BusinessIntranet.BusinessIntranet.Models;

import com.BusinessIntranet.BusinessIntranet.Enums.Department;

import javax.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String phone;
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private Department department;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String jobTitle, String imageUrl, String phone, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.imageUrl = imageUrl;
        this.phone = phone;
        this.department = department;
    }

    public Employee(Long id, String firstName, String lastName, String jobTitle, String imageUrl, String phone, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.imageUrl = imageUrl;
        this.phone = phone;
        this.department = department;
    }

    public Employee(Long id, String firstName, String lastName, String imageUrl, String phone, String jobTitle, Department department, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.department = department;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
