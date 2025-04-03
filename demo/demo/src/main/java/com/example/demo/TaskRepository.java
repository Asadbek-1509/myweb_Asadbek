package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface employeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findBySalaryGreaterThan(double threshold);
}

public interface TaskRepository extends JpaRepository<Task, Long> { }
