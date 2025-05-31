package com.sriram.ems.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sriram.ems.dto.EmployeeDto;
import com.sriram.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployeeEmployee(@RequestBody EmployeeDto employeeDto) {
	EmployeeDto savedEmployee =  service.createEmployee(employeeDto);	
    return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED); 		
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> list  = service.getAllEmployees();
		return new ResponseEntity(list,HttpStatus.OK);
			}
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id ){
		EmployeeDto employeedto = service.getEmployeeById(id);
		return ResponseEntity.ok(employeedto);
	}
    
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id , @RequestBody EmployeeDto employeeDto ){	 
    EmployeeDto dto = service.updateEmployees(employeeDto ,id);	
    return  ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long employeeID){
      service.DeleteEmployee(employeeID);
      return ResponseEntity.ok("Employee has been Deleted sucessfully!");
   }
}