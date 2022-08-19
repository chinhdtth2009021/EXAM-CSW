package com.example.examcsw.service;

import com.example.examcsw.model.Employee;
import com.example.examcsw.reponstory.EmployeeReponstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeReponstory employeeRepository;

    @Override
    public void save(Employee user) {
        employeeRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllByNameContainsIgnoreCase(String name) {
        return employeeRepository.findAllByNameContainsIgnoreCase(name);
    }
}
