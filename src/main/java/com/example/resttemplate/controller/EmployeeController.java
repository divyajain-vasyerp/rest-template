package com.example.resttemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.resttemplate.dto.EmployeeDTO;
import com.example.resttemplate.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees()
	{
		List<EmployeeDTO> allUsers = this.employeeService.getAllEmployees();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable ("id") int id)
	{
		EmployeeDTO employeeById = this.employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employeeById,HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeDTO createemployee = this.employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(createemployee,HttpStatus.OK);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeDTO updateEmployee = this.employeeService.updateEmployee(id, employeeDTO);
		return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id)
	{
		this.employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body("Id is Deleted Sucessfully: "+id);
	}
}
