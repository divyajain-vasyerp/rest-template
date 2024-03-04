package com.example.resttemplate.service;

import java.util.List;

import com.example.resttemplate.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(Integer employeeId);

	List<EmployeeDTO> getAllEmployees();

	void deleteEmployee(Integer employeeId);

}
