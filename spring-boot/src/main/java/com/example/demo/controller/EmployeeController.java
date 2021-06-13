package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
@Api(value = "Employe Service", description = "Employee data Services")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/saveEmployee")
    @ApiOperation(value = "Store Employess API")
    public String saveEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return "Employee saved.....";

    }

    @GetMapping("/getAllEmployess")
    @ApiOperation(value = "Get All Employees API")
    public List<Employee> getAll(){
        return repository.findAll();

    }

    @GetMapping("/getEmp/{dept}")
    @ApiOperation(value = "Get Employee By Dept")
    public List<Employee> getEmployeeByDept(@PathVariable String dept){
       return repository.findByDept(dept);

    }

    @GetMapping("/getEmployee/{id}")
    @ApiOperation(value = "Get Employee By Id")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id){
        return repository.findById(id);
    }
}
