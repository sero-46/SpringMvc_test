package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerId(int theId);

	public void deleteCustomerId(int theId);

	public Customer searchCustomerId(int theId);
	
}
