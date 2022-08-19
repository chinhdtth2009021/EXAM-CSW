package com.example.examcsw.service;

import com.example.examcsw.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employees);
    public void delete(Integer id);
    public Employee findById(Integer id);
    public List<Employee> findAll();
    public List<Employee> findAllByNameContainsIgnoreCase(String name);
}
