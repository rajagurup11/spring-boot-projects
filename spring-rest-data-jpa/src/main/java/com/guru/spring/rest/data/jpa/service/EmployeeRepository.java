package com.guru.spring.rest.data.jpa.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guru.spring.rest.data.jpa.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
