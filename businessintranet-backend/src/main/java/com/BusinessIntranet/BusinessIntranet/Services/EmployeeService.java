package com.BusinessIntranet.BusinessIntranet.Services;

import com.BusinessIntranet.BusinessIntranet.Configuration.Configuration;
import com.BusinessIntranet.BusinessIntranet.Exceptions.EmployeeNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Models.Account;
import com.BusinessIntranet.BusinessIntranet.Models.Employee;
import com.BusinessIntranet.BusinessIntranet.Repositories.AccountRepository;
import com.BusinessIntranet.BusinessIntranet.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    public final EmployeeRepository employeeRepository;
    public final AccountRepository accountRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AccountRepository accountRepository) {
        this.employeeRepository = employeeRepository;
        this.accountRepository = accountRepository;
    }

    public Employee createEmployee(Employee employee) {
        Account defaultAccount = new Account(employee.getFirstName() + employee.getLastName() + Configuration.EMAIL_DOMAIN,
                Configuration.INITIAL_PASSWORD);
        this.accountRepository.save(defaultAccount);
        employee.setAccount(defaultAccount);
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
}
