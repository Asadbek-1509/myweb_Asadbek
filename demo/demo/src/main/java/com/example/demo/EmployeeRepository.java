package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom method to find employees earning more than a given salary
    List<Employee> findBySalaryGreaterThan(double salary);
}
