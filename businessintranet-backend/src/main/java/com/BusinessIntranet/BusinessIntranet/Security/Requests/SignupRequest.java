package com.BusinessIntranet.BusinessIntranet.Security.Requests;


import com.BusinessIntranet.BusinessIntranet.Role.Role;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<Role> role = new HashSet<>();

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return this.role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
