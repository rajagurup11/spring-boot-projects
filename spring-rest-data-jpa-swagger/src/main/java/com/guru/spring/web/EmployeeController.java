package com.guru.spring.web;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.spring.domain.Employee;
import com.guru.spring.exception.handling.EmployeeNotFoundException;
import com.guru.spring.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String get() {
		return "Hello test....";
	}

	@GetMapping("/all")
	public ResponseEntity<Collection<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.findAllemployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		checkEmployeeExist(id);
		return ResponseEntity.ok(employeeService.findEmployeeById(id).get());
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.addEmployee(employee));
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		checkEmployeeExist(employee.getId());
		return ResponseEntity.ok(employeeService.addEmployee(employee));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		checkEmployeeExist(id);
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee with id : " + id + " deleted succesfully.");
	}

	private void checkEmployeeExist(Integer id) {
		Optional<Employee> employee = employeeService.findEmployeeById(id);
		if (employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id : " + id + " not found.");
		}
	}
}
