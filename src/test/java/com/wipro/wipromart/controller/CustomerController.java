package com.wipro.wipromart.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.wipromart.entity.Customer;
import com.wipro.wipromart.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerController {

	@MockBean
	private CustomerService customerService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testSaveCustomer() throws Exception {
	    Customer customer = new Customer();
	    customer.setCustomerId(100);
	    customer.setFirstName("ramesh");
	    customer.setLastName("rajan");
	    customer.setEmail("ramesh@gmail.com");
	    customer.setMobile("7036996919");
	    customer.setCity("Mallapur");

	    when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);

	    mockMvc.perform(post("/customer/save")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(new ObjectMapper().writeValueAsString(customer)))
	            .andExpect(status().isCreated())
	            .andExpect(jsonPath("$.customerId").value(100))
	            .andExpect(jsonPath("$.firstName").value("ramesh"))
	            .andExpect(jsonPath("$.lastName").value("rajan"))
	            .andExpect(jsonPath("$.email").value("ramesh@gmail.com"))
	            .andExpect(jsonPath("$.mobile").value("7036996919"))
	            .andExpect(jsonPath("$.city").value("Mallapur"));

	    verify(customerService, times(1)).saveCustomer(any(Customer.class));
	}
}