package com.example.resttemplate.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.resttemplate.dto.EmployeeDTO;
import com.example.resttemplate.exception.EmployeeIdNotFoundException;
import com.example.resttemplate.model.Employee;
import com.example.resttemplate.repository.EmployeeRepository;
import com.example.resttemplate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = this.modelMapper.map(employeeDTO,Employee.class);
		Employee employee2=employeeRepository.save(employee);
		return this.modelMapper.map(employee2, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employeeDTO) {
		Employee eId = this.employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeIdNotFoundException("EmployeeId is Not Found: "+employeeId));
		
		eId.setName(employeeDTO.getName());
		eId.setSalary(employeeDTO.getSalary());
		Employee updateEmployee = this.employeeRepository.save(eId);
		return this.modelMapper.map(updateEmployee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO getEmployeeById(Integer employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeIdNotFoundException("EmployeeId is Not Found: "+employeeId));
		return this.modelMapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> allEmployee = this.employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = allEmployee.stream().map(e->this.modelMapper.map(e, EmployeeDTO.class)).collect(Collectors.toList());
		return employeeDTOs;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeIdNotFoundException("EmployeeId is Not Found: "+employeeId));
	this.employeeRepository.delete(employee);
	}

}
