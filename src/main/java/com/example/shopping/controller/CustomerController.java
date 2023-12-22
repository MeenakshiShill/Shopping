package com.example.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.entity.Customer;
import com.example.shopping.sevice.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllcustomer(){
		List<Customer> customers =customerService.getAllCustomer();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	
	@GetMapping("/getById/{CustomerId}")
	public Optional<Customer> getById(@PathVariable("CustomerId") int CustomerId ){
		return customerService.GetByCustomerId(CustomerId);
	} 
	
	@PostMapping("/Create")
	public String createCustomer(@RequestBody Customer customer ) {
	customerService.CreateCustomer(customer);
		return "Creted";
	}
	
	@PutMapping("/Update/{CustomerId}")
	public String updateCustomer(@RequestBody Customer customer,@PathVariable("CustomerId") int CustomerId) {
		String result = customerService.UpdateCustomer(customer, CustomerId);
		return result;
	}
	
	@DeleteMapping("/Delete/{CustomerId}")
	public String deleteCustomer(@PathVariable("CustomerId") int CustomerId) {
		String delete = customerService.DeleteCustomer(CustomerId);
		return delete;
	}
	

	

}
