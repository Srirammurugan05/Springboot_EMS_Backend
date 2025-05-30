package com.sriram.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriram.ems.entity.Employee;

 public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	 
}
