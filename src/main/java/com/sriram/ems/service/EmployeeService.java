package com.sriram.ems.service;

import java.util.List;

import com.sriram.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(long id);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployees(EmployeeDto employeeDto , long id);
	void DeleteEmployee(long id);
	
}
