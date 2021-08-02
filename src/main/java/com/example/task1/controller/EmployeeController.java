package com.example.task1.controller;

import com.example.task1.command.CreateEmployeeCommand;
import com.example.task1.entity.Employee;
import com.example.task1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public ResponseEntity<List<Employee>> listEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employees = employeeRepository.findById(id);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("")
    public ResponseEntity<String> addEmployeeById(@RequestBody CreateEmployeeCommand createEmployeeCommand) {
        Boolean ok = employeeRepository.save(CreateEmployeeCommand.toEmployee(createEmployeeCommand));
        return ResponseEntity.ok(ok ? "ok": "error");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        Boolean ok = employeeRepository.deleteById(id);
        return ResponseEntity.ok(ok ? "ok": "error");
    }
}
