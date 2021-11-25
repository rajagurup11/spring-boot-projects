package com.guru.spring.rest.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.spring.rest.domain.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	static {
		Employee employee1 = new Employee(1, "Arun");
		Employee employee2 = new Employee(2, "Babu");
		Employee employee3 = new Employee(3, "Chan");
		Employee employee4 = new Employee(4, "Diva");
		employees.put(employee1.getId(), employee1);
		employees.put(employee2.getId(), employee2);
		employees.put(employee3.getId(), employee3);
		employees.put(employee4.getId(), employee4);
		System.out.println("Employees loaded : " + employees);
	}

	@GetMapping
	public String get() {
		return "Hello test....";
	}

	@GetMapping("/all")
	public ResponseEntity<Collection<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employees.values());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getemployeeById(@PathVariable Integer id) {
		return ResponseEntity.ok(employees.get(id));
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employees.put(employee.getId(), employee);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employees.put(employee.getId(), employee);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		employees.remove(id);
		return ResponseEntity.ok("Employee with id :" + id + " deleted succesfully.");
	}
}
