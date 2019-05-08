package com.course.api.repository;

import com.course.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByIdEmployee(Integer idEmp);
    Employee findEmployeeByUsernameAndPass(String username, String pass);
}
