package com.test.controller;

import com.test.controller.dto.EmployeeDto;
import com.test.model.Employee;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody EmployeeDto employee) {
		employeeService.addEmployee(employee);
	}


	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}


	@GetMapping
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
}
