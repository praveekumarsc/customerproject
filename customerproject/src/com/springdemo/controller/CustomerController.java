package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.Dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listcustomer(Model theModel) {
		
		//get the customer from the dao
		List<Customer> theCustomers=customerDAO.getCustomers();

		//add the customer to model
		theModel.addAttribute("customers",theCustomers);
		return "list-customer";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		//create  model attribute to bind form data
		Customer theCustomer=new Customer();
		
		//add the data to model
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";	
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer){
		customerDAO.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("customerId")int theId,Model theModel) {
		//get the customer  from the database
		
		Customer theCustomer=customerDAO.getCustomer(theId);
		//set the customer as a model
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int thId) {
		
		
		customerDAO.deleteCustomer(thId);
		return "redirect:/customer/list";
		
	}
	
	
}
