package com.example.javatpoint.SpringbootCruddemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.javatpoint.SpringbootCruddemo.dao.EmployeeRepository;
import com.example.javatpoint.SpringbootCruddemo.entity.Employee;
import com.example.javatpoint.SpringbootCruddemo.model.EmployeeModel;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	@Override
	public List<Employee> get() {

		return employeeRepository.findAll();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		Optional<Employee> e = employeeRepository.findById(id);
		if(e.isPresent()) {
			return e.get();
		}else {
			throw new RuntimeException("No record found");
		}
	}

	@Transactional
	@Override
	public void save(EmployeeModel emp) {
		
		Employee e = new Employee();
		e.setAddress(emp.getAddress());
		try {
			e.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(emp.getDob()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.setGender(emp.getGender());
		e.setName(emp.getName());
		employeeRepository.save(e);

	}

	@Transactional
	@Override
	public void delete(int id) {
	 employeeRepository.deleteById(id);;

	}

}
