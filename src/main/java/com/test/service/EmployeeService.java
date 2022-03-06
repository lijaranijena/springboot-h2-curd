package com.test.service;

import com.test.controller.dto.EmployeeDto;
import com.test.exception.EmployeeManagementException;
import com.test.exception.InternalStandardErrors;
import com.test.model.Employee;
import com.test.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	public void addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		repo.save(employee);
		log.info("Employee saved successfully !!");
	}


	public Employee getEmployee(String id) {
		Optional<Employee> byId = repo.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		}
		throw new EmployeeManagementException(InternalStandardErrors.EMP_ID_NOT_EXIST);
	}


	public List<Employee> getAll() {
		return repo.findAll();
	}
}
