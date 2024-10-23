package com.hrmanagement.service;

import com.hrmanagement.model.Employee;
import com.hrmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Map<String, String> authentificationEmployee(String email, String password) {
        Map<String, String> response = new HashMap<>();
        Optional<Employee> employeeOption = employeeRepository.findByEmailAndPassword(email, password);
        if (employeeOption.isPresent()) {
            response.put("message", "Authentication success");
            return response;
        }
        response.put("message", "Authentication failed");
        return response;
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository.findByEmail(employee.getEmail());
        if (employeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
    }
}
