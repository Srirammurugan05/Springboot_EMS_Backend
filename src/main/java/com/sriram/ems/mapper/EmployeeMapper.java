package com.sriram.ems.mapper;

import com.sriram.ems.dto.EmployeeDto;
import com.sriram.ems.entity.Employee;

public class EmployeeMapper {
   
  public static EmployeeDto mapEntityToDto(Employee employee) {
	  return new EmployeeDto(employee.getId(),
			  employee.getFirstName(),
			  employee.getLastName(),
			  employee.getEmail());
  } 
  
  public static Employee mapDtoToEntity(EmployeeDto employeeDto) {
	  return new Employee(employeeDto.getId(),
			  employeeDto.getFirstName(),
			  employeeDto.getLastName(),
			  employeeDto.getEmail());
  } 
	
}
