package com.BusinessIntranet.BusinessIntranet.Services;

import com.BusinessIntranet.BusinessIntranet.Exceptions.EmployeeNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Models.Employee;
import com.BusinessIntranet.BusinessIntranet.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {
    public final EmployeeRepository employeeRepository;
    public final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " does not exist."));
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = this.employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with email " + email + " does not exist."));
        return new User(employee.getEmail(), employee.getPassword(), new ArrayList<>()); // TODO: Define roles
    }
}
