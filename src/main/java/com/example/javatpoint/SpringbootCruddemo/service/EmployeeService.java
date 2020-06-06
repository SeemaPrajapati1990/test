package com.example.javatpoint.SpringbootCruddemo.service;

import java.util.List;

import com.example.javatpoint.SpringbootCruddemo.entity.Employee;
import com.example.javatpoint.SpringbootCruddemo.model.EmployeeModel;

public interface EmployeeService {
	 public List<Employee> get();
	 public Employee get(int id);
	 public void save(EmployeeModel emp);
	 public void delete(int id);
}
