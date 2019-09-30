package com.org.lambda.api;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("test")
	public ResponseEntity<String> test() {
		System.out.println("Service is up and running...!");
		return new ResponseEntity<String>("Service is up and running...!", HttpStatus.OK);
	}
	
	/*@GetMapping("all")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		if(!employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Employee>>(Collections.emptyList(), HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping
	public ResponseEntity<Employee> getEmployee(@RequestParam("aadharNumber") long aadharNumber) {
//		Optional<Employee> optional = employeeRepo.findById(aadharNumber);
//		if(optional.isPresent()) {
//			return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Employee>(new Employee(), HttpStatus.NO_CONTENT);
//		}
		
		Employee employee = employeeRepo.findByAadharNumber(aadharNumber);
		if(employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(new Employee(), HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		
		Employee existingEmployee = employeeRepo.findByAadharNumber(employee.getAadharNumber());
		
		if(existingEmployee != null) {
			return new ResponseEntity<String>(
					"An employee with this Aadhar number already exist. You may use update api to update this employee",
					HttpStatus.CONFLICT);
		}
		
		employeeRepo.save(employee);
		return new ResponseEntity<String>("Employee added successfully", HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		
		Employee existingEmployee = employeeRepo.findByAadharNumber(employee.getAadharNumber());
		
		if(existingEmployee == null) {
			return new ResponseEntity<String>("No employee found with this Aadhar number", HttpStatus.NOT_FOUND);
		}
		
		employeeRepo.save(employee);
		return new ResponseEntity<String>("Employee updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteEmployee(@RequestParam("aadharNumber") long aadharNumber) {
//		employeeRepo.deleteById(aadharNumber);
//		employeeRepo.deleteByAadharNumber(aadharNumber);
		
		Employee existingEmployee = employeeRepo.findByAadharNumber(aadharNumber);
		
		if(existingEmployee == null) {
			return new ResponseEntity<String>("No employee found with this Aadhar number", HttpStatus.NOT_FOUND);
		}
		
		employeeRepo.delete(existingEmployee);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}*/

}
