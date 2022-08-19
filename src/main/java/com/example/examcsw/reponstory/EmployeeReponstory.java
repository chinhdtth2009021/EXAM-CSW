package com.example.examcsw.reponstory;

import com.example.examcsw.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReponstory extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
    List<Employee> findAllByNameContainsIgnoreCase(String name);
    List<Employee> findAllByNameAndSalary(String name, String email);
    List<Employee> findAllByNameOrderBySalaryAsc(String name);
}