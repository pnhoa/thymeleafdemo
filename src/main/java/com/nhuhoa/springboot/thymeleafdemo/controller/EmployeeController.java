package com.nhuhoa.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhuhoa.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		// create employees
		Employee emp1 = new Employee(1, "Hoa", "Pham", "hoapham123@gmail.com");
		Employee emp2 = new Employee(2, "A", "Le", "lea@gmail.com");
		Employee emp3 = new Employee(3, "Quan", "Pham", "quanpham123@gmail.com");

		// create the list
		theEmployees = new ArrayList<Employee>();
		
		// add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
