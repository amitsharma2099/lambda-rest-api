package com.org.lambda.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class RestApiGatewayReqRes implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
    	System.out.println("Inside apply method....");
//    	System.out.println("APIGatewayProxyRequestEvent INPUT is: "+ input.toString());
    	System.out.println("HttpMethod is: "+ input.getHttpMethod());
        String respJson = "";

        //PUT: Update employee
        /*ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = input.getBody();
        System.out.println("requestBody is: "+ requestBody);
        Employee employee = null;
        try {
        	employee = objectMapper.readValue(requestBody, Employee.class);
        	System.out.println("Json Parsing Done....");
        	System.out.println("employee: "+ employee);
		} catch (IOException e) {
			System.out.println("Exception occurred in parsing json string to Employee...!");
			e.printStackTrace();
		}
        
        Employee existingEmployee = employeeRepo.findByAadharNumber(employee.getAadharNumber());
        if(existingEmployee == null) {
			respJson = "No employee found with this Aadhar number";
		} else {
			existingEmployee.setAge(employee.getAge());
			existingEmployee.setDepartment(employee.getDepartment());
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setSalary(employee.getSalary());
			
			employeeRepo.save(existingEmployee);
			respJson = "Employee updated successfully";
		}*/

        
        //Post: Create new employee
        /*ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = input.getBody();
        System.out.println("requestBody is: "+ requestBody);
        Employee employee = null;
        try {
        	employee = objectMapper.readValue(requestBody, Employee.class);
        	System.out.println("Json Parsing Done....");
        	System.out.println("employee: "+ employee);
		} catch (IOException e) {
			System.out.println("Exception occurred in parsing json string to Employee...!");
			e.printStackTrace();
		}
        
        Employee existingEmployee = employeeRepo.findByAadharNumber(employee.getAadharNumber());
		if(existingEmployee != null) {
			respJson = "An employee with this Aadhar number already exist. You may use update api to update this employee";
		} else {
			employeeRepo.save(employee);
			respJson = "New employee added successfully";
		}*/

		
        //Delete an employee
        /*long aadharNumber = getAadharNumber(input);
        Employee employee = employeeRepo.findByAadharNumber(aadharNumber);
        if(employee != null) {
        	employeeRepo.delete(employee);
        	respJson = "Employee deleted successfully";
		} else {
			respJson = "No employee found with this Aadhar number...!";
		}*/
        
        
        //Get detail of one employee
        /*long aadharNumber = getAadharNumber(input);
        Employee employee = employeeRepo.findByAadharNumber(aadharNumber);
        if(employee != null) {
			ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	    	try {
				respJson = objectMapper.writeValueAsString(employee);
			} catch (JsonProcessingException e) {
				System.out.println("JsonProcessingException has occurred...!");
				e.printStackTrace();
			}
		} else {
			respJson = "No record found...!";
		}*/
		

		//Get all employees
        List<Employee> employees = employeeRepo.findAll();
        System.out.println("Total Employees: "+employees.size());
        
        if(!employees.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
//	    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	    	try {
				respJson = objectMapper.writeValueAsString(employees);
			} catch (JsonProcessingException e) {
				System.out.println("JsonProcessingException has occurred...!");
				e.printStackTrace();
			}
		} else {
			respJson = "No record found...!";
		}
        
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
//        responseEvent.setBody("Hello! Reached the Spring Cloud Function with message: " + input.getBody());
//        responseEvent.setBody("Hello! Reached the Spring Cloud Function with message: " + aadharNumberStr);
        System.out.println(respJson);
        responseEvent.setBody(respJson);
        
        return responseEvent;
    }

	private long getAadharNumber(APIGatewayProxyRequestEvent input) {
		Map<String, String> queryStringParameters = input.getQueryStringParameters();
        System.out.println("queryStringParameters: "+ queryStringParameters);
//      Map<String, String> pathParameters = input.getPathParameters();
        
        String aadharNumberStr = "";
        long aadharNumber = 0L;
        if(queryStringParameters != null) {
        	aadharNumberStr = queryStringParameters.entrySet().stream()
        			.filter(entry -> "aadharNumber".equalsIgnoreCase(entry.getKey()))
        			.map(entry -> entry.getValue())
        			.collect(Collectors.joining());
        }
        
        System.out.println("aadharNumber: "+ aadharNumberStr);
        if(aadharNumberStr != null && !"".equals(aadharNumberStr)){
        	aadharNumber = Long.parseLong(aadharNumberStr);
        }
		return aadharNumber;
	}
	
	/*@Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
    	System.out.println("Inside apply method....");
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
        responseEvent.setBody("Hello! Reached the Spring Cloud Function with message: " + input.getBody());
        return responseEvent;
    }*/
}