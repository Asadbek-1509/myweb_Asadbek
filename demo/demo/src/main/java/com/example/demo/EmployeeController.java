package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final employeeRepository repository;

    public EmployeeController(employeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return repository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSurname(updatedEmployee.getSurname());
            employee.setSalary(updatedEmployee.getSalary());
            return repository.save(employee);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/salary/{threshold}")
    public List<Employee> getBySalaryThreshold(@PathVariable double threshold) {
        return repository.findBySalaryGreaterThan(threshold);
    }


    @RestController
    @RequestMapping("/employees")
    public class employeeController {
        private final EmployeeRepository employeeRepository;

        public employeeController(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        @PostMapping
        public Employee addEmployee(@RequestBody Employee employee) {
            return employeeRepository.save(employee);
        }
    }

}
