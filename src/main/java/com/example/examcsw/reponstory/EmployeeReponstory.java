package com.example.examcsw.reponstory;

import com.example.examcsw.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeReponstory {
    List<Employee> findAllByName(String name);
}