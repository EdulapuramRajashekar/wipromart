package com.wipro.wipromart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.wipromart.entity.Customer;
import com.wipro.wipromart.repository.CustomerRepository;


@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerService customerService =new CustomerServiceImpl();

	@Mock
	private CustomerRepository customerRepository;
	
	@Test
	void testGetCustomerById() {
		Customer customer=new Customer();
		customer.setCustomerId(100);
		customer.setFirstName("Noname");
		customer.setLastName("Lname");
		customer.setEmail("noname@gmail.com");
		customer.setMobile("7036996911");
		customer.setCity("Kerala");
		
		Optional<Customer> optionalCustomer=Optional.of(customer);
		when(customerRepository.findById(100L)).thenReturn(optionalCustomer);
		
		Customer actualCustomer=customerService.getCustomerById(100);
		
		assertEquals("Noname",actualCustomer.getFirstName());
		assertEquals("Kerala",actualCustomer.getCity());
	
	}
	@Test
	void testSaveCustomer() {
		
		Customer customer=new Customer();
		customer.setCustomerId(100);
		customer.setFirstName("Noname");
		customer.setLastName("Lname");
		customer.setEmail("noname@gmail.com");
		customer.setMobile("7036996911");
		customer.setCity("Kerala");
		
		when(customerRepository.save(customer)).thenReturn(customer);
		
		Customer newCustomer = customerService.saveCustomer(customer);
		
		assertEquals(100,newCustomer.getCustomerId());
		assertEquals("Noname",newCustomer.getFirstName());
		assertEquals("noname@gmail.com",newCustomer.getEmail());
		assertEquals("Kerala",newCustomer.getCity());		
	}
	@Test
	void testGetAllCustomers() {
		Customer customer=new Customer();
		customer.setCustomerId(100);
		customer.setFirstName("Noname");
		customer.setLastName("Lname");
		customer.setEmail("noname@gmail.com");
		customer.setMobile("7036996911");
		customer.setCity("Kerala");
		
		Customer customer1=new Customer();
		customer1.setCustomerId(1000);
		customer1.setFirstName("Nonames");
		customer1.setLastName("Lnames");
		customer1.setEmail("nonames@gmail.com");
		customer1.setMobile("7036996910");
		customer1.setCity("Keralai");
		
		Customer customer3=new Customer();
		customer3.setCustomerId(10000);
		customer3.setFirstName("Nonamess");
		customer3.setLastName("Lnamess");
		customer3.setEmail("nonamess@gmail.com");
		customer3.setMobile("7036996913");
		customer3.setCity("Keralal");
		
		List<Customer> myCustomers = new ArrayList<>();		
		myCustomers.add(customer);
		myCustomers.add(customer1);
		myCustomers.add(customer3);
		
		when(customerRepository.findAll()).thenReturn(myCustomers);
		
		List<Customer> customerList = customerService.getAllCustomers();
		
		assertEquals(myCustomers.size(),customerList.size());
		
	}
}
