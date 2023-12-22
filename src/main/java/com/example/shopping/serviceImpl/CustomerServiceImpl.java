package com.example.shopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.entity.Customer;
import com.example.shopping.repository.CustomerRepository;
import com.example.shopping.sevice.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Optional<Customer> GetByCustomerId(int id) {
		Optional<Customer> customer =customerRepository.findById( id);
		return customer;
	}

	@Override
	public String CreateCustomer(Customer customer) {
		customerRepository.save(customer);
		return "CustomerCreated";
	}

	@Override
	public String UpdateCustomer(Customer customer, int id) {
		 customer.setId(id);
		 customerRepository.save(customer);
		return "Customer Updated";
	}

	@Override
	public String DeleteCustomer(int id) {
		customerRepository.deleteById(id);
		return "CustomerDeleted";
	}

}
