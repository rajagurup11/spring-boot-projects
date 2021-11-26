package com.guru.spring.rest.data.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guru.spring.rest.data.jpa.domain.Employee;

@Service
public interface EmployeeService {

	List<Employee> findAllemployees();

	Optional<Employee> findEmployeeById(int id);

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(int id);

}
