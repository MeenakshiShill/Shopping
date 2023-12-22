package com.example.shopping.sevice;

import java.util.List;
import java.util.Optional;

import com.example.shopping.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomer();
	Optional<Customer> GetByCustomerId(int id);
	String CreateCustomer(Customer customer);
	String UpdateCustomer(Customer customer,int id);
	String DeleteCustomer(int id);

}
