package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
