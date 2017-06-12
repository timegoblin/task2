/**
 * 
 */
package com.centrica.httptask.api.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centrica.httptask.api.EmployeeApi;
import com.centrica.httptask.api.model.Employee;
import com.centrica.httptask.service.EmployeeService;

/**
 * Public greeting api endpoint controller, implementing greetings interface for public
 * 
 * @author wemccl
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeApi {

	@Autowired
	EmployeeService employeeService ;
	
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Employee> getEmployee (@PathVariable("employeeId") String employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK) ;
	}
    
}