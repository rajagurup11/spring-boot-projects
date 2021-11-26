package com.guru.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guru.spring.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
