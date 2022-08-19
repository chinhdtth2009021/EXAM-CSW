package com.example.examcsw.controller;

import com.example.examcsw.model.Employee;
import com.example.examcsw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeControler {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllEmployee() {
        List<Employee> list = employeeService.findAll();
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Employee> save(@RequestBody Employee employees) {
        employeeService.save(employees);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@PathParam("id") Integer id, @RequestBody Employee employees) {
        Employee oldEmployees = employeeService.findById(id);
        oldEmployees.setName(employees.getName());
        oldEmployees.setSalary(employees.getSalary());
        employeeService.save(oldEmployees);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateE(@PathVariable(value = "id") Integer id, @RequestBody Employee employees) {
        Employee oldEmployees = employeeService.findById(id);
        oldEmployees.setName(employees.getName());
        oldEmployees.setSalary(employees.getSalary());
        employeeService.save(oldEmployees);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> delete(@PathVariable(value = "id") Integer id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findEmployeesByName(@PathParam("name") String name) {
        List<Employee> list = employeeService.findAllByNameContainsIgnoreCase(name);
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }
}
