package com.BusinessIntranet.BusinessIntranet.Repositories;

import com.BusinessIntranet.BusinessIntranet.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
