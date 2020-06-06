package com.example.javatpoint.SpringbootCruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javatpoint.SpringbootCruddemo.entity.Employee;
import com.example.javatpoint.SpringbootCruddemo.model.EmployeeModel;
import com.example.javatpoint.SpringbootCruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api") 
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/getEmployee")
	public List<Employee> get() {
		return empService.get();
	}

	@PostMapping("/employee")
	public void save(@RequestBody EmployeeModel emp) {
		empService.save(emp);

	}

	@GetMapping("/employee/{/id}")
	public Employee get(@PathVariable int id) {
		Employee emp = empService.get(id);
		if (emp == null) {
			throw new RuntimeException("Id not found");
		} else {
			return empService.get(id);
		}
	}

	@DeleteMapping("/employee/{/id}")
	public String delete(@PathVariable int id) {
		empService.delete(id);
		return "employee has been deleted";
	}

}
