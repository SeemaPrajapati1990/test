package com.example.javatpoint.SpringbootCruddemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javatpoint.SpringbootCruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findById(Integer id);
}
