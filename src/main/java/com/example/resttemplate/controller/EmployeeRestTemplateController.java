package com.example.resttemplate.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.resttemplate.model.Employee;

//RestTemplateController.java
@RestController
public class EmployeeRestTemplateController {

	private final String URI_EMPLOYEE = "http://localhost:8080/api/employees";
	private final String URI_EMPLOYEE_ID = "http://localhost:8080/api/employees/";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/v3/allEmployees")
	public ResponseEntity getAllV3() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.GET, entity, Employee[].class);
	}

	@GetMapping("/v3/employees/{id}")
	public ResponseEntity getByIdV3(@PathVariable final Integer id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		return restTemplate.exchange(URI_EMPLOYEE_ID + id, HttpMethod.GET, entity, Employee.class);
	}

	@PostMapping("/v3/employees")
	public ResponseEntity createV3(@RequestBody final Employee newEmployee) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<>(newEmployee, httpHeaders);
		return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.POST, entity, Employee.class);
	}

	@PutMapping("/v3/employees/{id}")
	public ResponseEntity updateEmployeeV3(@PathVariable final Integer id, @RequestBody Employee newEmployee) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<>(newEmployee, httpHeaders);
		return restTemplate.exchange(URI_EMPLOYEE_ID + id, HttpMethod.PUT, entity, Employee.class);
	}

	@DeleteMapping("/v3/employees/{id}")
	public ResponseEntity deleteV3(@PathVariable final Integer id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<>(httpHeaders);
		return restTemplate.exchange(URI_EMPLOYEE_ID + id, HttpMethod.DELETE, entity, String.class);
	}

//	@DeleteMapping("/v1/employees/{id}")
//	public ResponseEntity<?> deleteV1(@PathVariable final Integer id) {
//		Map<String, String> params = new HashMap<>();
//		params.put("id", String.valueOf(id));
//		restTemplate.delete(URI_EMPLOYEE_ID, params);
//		return new ResponseEntity<>("Employee deleted with id " + id, HttpStatus.OK);
//	}
}
