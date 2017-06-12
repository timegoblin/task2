/**
 * 
 */
package com.centrica.httptask;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.centrica.httptask.api.model.Employee;
import com.centrica.httptask.service.EmployeeService;
import com.centrica.httptask.service.impl.EmployeeDataService;
import com.centrica.httptask.service.model.Greeting;

/**
 * @author wemccl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration() 
@EnableAutoConfiguration
@ActiveProfiles("local")
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService = new EmployeeDataService();
	
	@Mock
	RestTemplate restTemplate ;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEmployee_200_OK_Test() throws Exception {
		when(restTemplate.getForObject(Matchers.anyString(), Matchers.any())).thenReturn(new Greeting("Hello John")) ;
		Employee emp1 = employeeService.getEmployee("123456") ;
		assertNotNull(emp1) ;
		assertTrue(emp1.getId().equals("123456")) ;
		assertTrue(emp1.getMotd().equals("Hello John")) ;
	}

}
