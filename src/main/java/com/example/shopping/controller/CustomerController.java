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
    public ResponseEntity<Object> getAllCustomer() {
        try {
            List<Customer> customers = customerService.getAllCustomer();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return new ResponseEntity<>("An error occurred while fetching customers", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{CustomerId}")
    public ResponseEntity<Object> getById(@PathVariable("CustomerId") int CustomerId) {
        try {
            Optional<Customer> customer = customerService.GetByCustomerId(CustomerId);
            if (customer.isPresent()) {
                return new ResponseEntity<>(customer.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return new ResponseEntity<>("An error occurred while fetching the customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Create")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        try {
            customerService.CreateCustomer(customer);
            return new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return new ResponseEntity<>("An error occurred while creating the customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Update/{CustomerId}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable("CustomerId") int CustomerId) {
        try {
            String result = customerService.UpdateCustomer(customer, CustomerId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return new ResponseEntity<>("An error occurred while updating the customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Delete/{CustomerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("CustomerId") int CustomerId) {
        try {
            String delete = customerService.DeleteCustomer(CustomerId);
            return new ResponseEntity<>(delete, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return new ResponseEntity<>("An error occurred while deleting the customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

