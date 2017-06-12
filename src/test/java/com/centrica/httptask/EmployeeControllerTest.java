/**
 * 
 */
package com.centrica.httptask;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.centrica.httptask.api.controller.EmployeeController;
import com.centrica.httptask.api.model.Employee;
import com.centrica.httptask.service.EmployeeService;

/**
 * @author wemccl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration() 
@EnableAutoConfiguration
@ActiveProfiles("local")
public class EmployeeControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService ;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void getEmployee_200_OK_Test() throws Exception {
		when(employeeService.getEmployee(Matchers.anyString())).thenReturn(new Employee("123556")) ;
		this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/123556"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("{\"id\":\"123556\",\"name\":null,\"motd\":null}"));
	}

	@Test
	public void getEmployeeController_404_Fail_Test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/12345/jjj")).andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
