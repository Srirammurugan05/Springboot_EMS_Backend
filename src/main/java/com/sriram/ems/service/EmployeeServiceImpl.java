package com.sriram.ems.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sriram.ems.dto.EmployeeDto;
import com.sriram.ems.entity.Employee;
import com.sriram.ems.exception.ResourceNotFoundException;
import com.sriram.ems.mapper.EmployeeMapper;
import com.sriram.ems.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repo ; 
	
	public EmployeeDto createEmployee(EmployeeDto employeeDto) { 
	
	  Employee employee = EmployeeMapper.mapDtoToEntity(employeeDto);
	  Employee savedEmployee =  repo.save(employee);
      return EmployeeMapper.mapEntityToDto(savedEmployee);
      
	}


	public EmployeeDto getEmployeeById(long id) {
		Employee employee = repo.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Employee not exist for thr id :"+ id)
						);
		EmployeeDto employeeDto = EmployeeMapper.mapEntityToDto(employee);
		return employeeDto ;
 	}


	public List<EmployeeDto> getAllEmployees() {
      
	  List<Employee> list = repo.findAll();
	   
	  return list.stream()
			  .map((employee)-> EmployeeMapper.mapEntityToDto(employee))
			  .collect(Collectors.toList());
	}

	
	public EmployeeDto updateEmployees(EmployeeDto employeeDto , long id) 
	{
	    
	    	Employee employee  =  repo.findById(id)
	    			.orElseThrow(
	    					()-> new ResourceNotFoundException("Employee not exist for the id: "+id)
	    					); 
	
	        employee.setId(id);
	        employee.setFirstName(employeeDto.getFirstName());
	        employee.setLastName(employeeDto.getLastName());
	        employee.setEmail(employeeDto.getEmail());
	       
	        Employee updatedEmployee = repo.save(employee);
	        return EmployeeMapper.mapEntityToDto(updatedEmployee);

	}

	public void DeleteEmployee(long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}else throw new ResourceNotFoundException("Employee not found with given id :"+id);
	}
}
