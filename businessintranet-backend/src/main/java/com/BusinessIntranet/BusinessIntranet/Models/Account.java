package com.BusinessIntranet.BusinessIntranet.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(unique = true)
    private String primaryEmail;

    @ElementCollection
    private Set<String> emailGroups;

    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
    @JsonIgnore
    private Employee employee;


    public Account() {
    }

    public Account(Long id, String primaryEmail, String password) {
        this.id = id;
        this.primaryEmail = primaryEmail;
        this.password = password;
    }

    public Account(String primaryEmail, String password) {
        this.primaryEmail = primaryEmail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String email) {
        this.primaryEmail = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
