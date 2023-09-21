package com.springstudy.employeedirectory.controller;

import com.springstudy.employeedirectory.entity.Employee;
import com.springstudy.employeedirectory.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {

		// get employees from database
		List<Employee> employees = employeeService.findAll();
		// add to the spring model
		model.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String addEmployee(Model model){

		// create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@ModelAttribute("employeeId") int id, Model model){

		Employee employee = employeeService.findById(id);

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForDelete")
	public String deleteEmployee(@ModelAttribute("employeeId") int id) {

		employeeService.deleteById(id);

		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){

		// save employee
		employeeService.save(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

}









