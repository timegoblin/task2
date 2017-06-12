/**
 * 
 */
package com.centrica.httptask.api;

import org.springframework.http.ResponseEntity;

import com.centrica.httptask.api.model.Employee;

/**
 * Greeting api interface definition
 * 
 * @author wemccl
 *
 */
public interface EmployeeApi {

	/**
	 * Greeting api method to return greeting
	 * 
	 * @return
	 */
	public ResponseEntity<Employee> getEmployee(String employeeId);

}
