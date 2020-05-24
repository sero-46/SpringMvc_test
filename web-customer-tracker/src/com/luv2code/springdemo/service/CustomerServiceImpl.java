package com.luv2code.springdemo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Staff;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	 @Autowired 
	 private CustomerDAO customerDAO;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {	
		
		return customerDAO.getCustomers();		
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {


		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerId(int theId) {
		
		return customerDAO.getCustomerId(theId);
	}

	@Override
	@Transactional
	public void deleteCustomerId(int theId) {
		 customerDAO.deleteCustomerId(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomerId(String theName) {

		return customerDAO.searchCustomerId(theName);
	}

	@Override
	@Transactional
	public List<Staff> queryCustomerId(int theCusId) {

		return customerDAO.queryCustomerId(theCusId);
	}
	
	@Override
	@Transactional
	public List<Customer> searchcusStaff(int theCusId) {

		return customerDAO.searchcusStaff(theCusId);
	}

	
}
