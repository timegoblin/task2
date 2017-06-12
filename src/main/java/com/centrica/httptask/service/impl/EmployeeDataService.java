/**
 * 
 */
package com.centrica.httptask.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.centrica.httptask.api.model.Employee;
import com.centrica.httptask.service.EmployeeService;
import com.centrica.httptask.service.model.Greeting;
import com.centrica.httptask.service.model.Motd;

/**
 * @author wemccl
 *
 */
@Component
public class EmployeeDataService implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeDataService.class);
	
	@Autowired
	RestTemplate motdRestServiceTemplate ;
	
	@Value("${remote.server.uri}")
	private String remoteUri;

    /**
     * 
     */
	public Employee getEmployee(String employeeId) {
		Employee employee = getEmployeeById(employeeId) ;
		// Call remote motd service
		Motd motd = getMotdForEmployeeById(employeeId) ;
		employee.setMotd(motd.getMessage());
		return employee;
	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	private Motd getMotdForEmployeeById(String employeeId) {
		// 
		Greeting greeting = motdRestServiceTemplate.getForObject(remoteUri, Greeting.class);
		log.info(greeting.toString());		
		Motd motd = new Motd(greeting.getMessage()) ;
		return motd ;
	};

	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	private Employee getEmployeeById( String employeeId ) {
		// Get employee.. in 'real situation this would involve query via DAO to employee db
		Employee employee = new Employee(employeeId);
		employee.setName("John Smith");
		return employee ;
	}
}
