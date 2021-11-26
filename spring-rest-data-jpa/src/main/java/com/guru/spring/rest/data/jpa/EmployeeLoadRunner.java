package com.guru.spring.rest.data.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.guru.spring.rest.data.jpa.domain.Employee;
import com.guru.spring.rest.data.jpa.service.EmployeeService;

@Component
public class EmployeeLoadRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private EmployeeService employeeService;

	public EmployeeLoadRunner(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee(1, "Arun");
		Employee employee2 = new Employee(2, "Babu");
		employeeService.addEmployee(employee1);
		employeeService.addEmployee(employee2);
		logger.info("Employees loaded, employees are :" + employeeService.findAllemployees());
	}

}
