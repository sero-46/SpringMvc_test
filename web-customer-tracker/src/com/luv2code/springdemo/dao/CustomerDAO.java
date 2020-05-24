package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Staff;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerId(int theId);

	public void deleteCustomerId(int theId);

	public List<Customer> searchCustomerId(String theName);

	public List<Staff> queryCustomerId(int theCusId);

	public List<Customer> searchcusStaff(int theCusId);

	

	
	
	
	
}
