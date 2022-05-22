package com.BusinessIntranet.BusinessIntranet.Employee;

import com.BusinessIntranet.BusinessIntranet.Employee.DTOs.EmployeeDTO;
import com.BusinessIntranet.BusinessIntranet.Employee.Exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public final EmployeeRepository employeeRepository;
    public final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public List<EmployeeDTO> findAllEmployeesDTO(){
        return this.employeeRepository.findAll().stream().map(Employee::toEmployeeDTO).collect(Collectors.toList());
    }

    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " does not exist."));
    }

    public Employee findEmployeeByEmail(String email) {
        return this.employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + email + " does not exist."));
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " does not exist."));
        this.employeeRepository.deleteById(id);
    }

    public boolean employeeEmailExists(String email) {
        return employeeRepository.existsEmployeeByEmail(email);
    }

}
