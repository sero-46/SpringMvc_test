package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Staff;
import com.luv2code.springdemo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;

	
	@RequestMapping("/list")
	public String listCustomer(Model theModel)
	{
		List<Customer> customersList=customerService.getCustomers();
	
		theModel.addAttribute("customers",customersList);
		return "list-customers";		
	}
	
	@GetMapping("/showAddForm")
	public String showpage(Model theModel)
	{
		Customer c=new Customer();
		theModel.addAttribute("customermodels",c);		
		return "add-customer";
		
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customermodels") Customer theCustomer)
	{
	 
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomerId(@RequestParam("theSearchName") String theName, Model theModel)
	{
		List<Customer> cus=customerService.searchCustomerId(theName);
		theModel.addAttribute("customers",cus);
			
		return "list-customers";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel)
	{
		Customer cus=customerService.getCustomerId(theId);
		
		theModel.addAttribute("customermodels",cus);
		return "add-customer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel)
	{
		customerService.deleteCustomerId(theId);		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/query")
	public String queryCustomerId(@RequestParam("cusId") int theCusId, Model theModel)
	{
		List<Staff> cus=customerService.queryCustomerId(theCusId);
		theModel.addAttribute("staff",cus);
			
		return "list-staff";
	}
	
	@GetMapping("/cusStaffquery")
	public String searchcusStaff(@RequestParam("cusId") int theCusId, Model theModel)
	{
		List<Customer> cus=customerService.searchcusStaff(theCusId);
		theModel.addAttribute("cusStaff",cus);
			
		return "list-cus-staff";
	}
	
	
}

















