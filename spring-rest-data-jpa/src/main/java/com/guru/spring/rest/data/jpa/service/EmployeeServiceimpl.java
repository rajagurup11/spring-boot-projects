package com.guru.spring.rest.data.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guru.spring.rest.data.jpa.domain.Employee;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAllemployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	@Override
	public Optional<Employee> findEmployeeById(int empId) {
		return employeeRepository.findById(empId);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
	}

}
