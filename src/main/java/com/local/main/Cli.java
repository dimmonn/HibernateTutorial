package com.local.main;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.local.entity.Department;
import com.local.entity.Employee;
import com.local.service.DepartmentServiceImpl;
import com.local.service.EmployeeServiceImpl;

import util.AppContextHolder;

public class Cli {
	private static final Logger log = Logger.getLogger(Cli.class.getName());
	private String[] args = null;
	private Options options = new Options();

	public Cli(String[] args) {

		this.args = args;
		Option ed = new Option("ed", "editDept", true, "Edit an existing dept");
		ed.setArgs(2);
		Option ae = new Option("ae", "addEmpl", true, "Add an employee to an existing dept");
		ae.setArgs(2);
		options.addOption("h", "help", false, "show help.");
		options.addOption("nd", "addDept", true, "Add new dept");
		options.addOption("rm", "removeDept", true, "Remove an existing dept");
		options.addOption("sh", "showDept", false, "Show an existing dept");
		options.addOption("fn", "findDept", true, "Find dept by id");
		options.addOption("fe", "findEmpl", true, "Find emp by id");
		options.addOption("re", "removeEmp", true, "remove emp by id");
		options.addOption(ed);
		options.addOption(ae);
	}

	public void parse() {
		// CommandLineParser parser = new BasicParser();

		CommandLineParser parser = new DefaultParser();

		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption("h"))
				help();

			if (cmd.hasOption("nd")) {
				Department department = addDept(cmd);
				log.log(Level.INFO, "Dept " + department + " is added");

			} else if (cmd.hasOption("ed")) {
				Department department = modifyDept(cmd);
				log.log(Level.INFO, "Dept " + department + " is modified");
			} else if (cmd.hasOption("rm")) {
				DepartmentServiceImpl departmentService = deleteDept(cmd);
				log.log(Level.INFO,
						"Dept " + departmentService.getDepartmentById(Integer.parseInt(cmd.getOptionValue("rm")))
								+ " is removed");
			} else if (cmd.hasOption("sh")) {
				List<Department> departments = getAllDepts();
				log.log(Level.INFO, departments.toString());
			} else if (cmd.hasOption("fn")) {
				Department department = findDept(cmd);
				log.log(Level.INFO, department.toString());
			} else if (cmd.hasOption("ae")) {
				Department department = addEmployeeToDept(cmd);
				log.log(Level.INFO, "Added employee to dept " + department);
			} else if (cmd.hasOption("fe")) {
				Set<Employee> employees = getEmployeeByDept(cmd);
				log.log(Level.INFO, "Employees with dept id " + cmd.getOptionValue("fe") + " are " + employees);
			} else if (cmd.hasOption("re")) {
				deleteEmployeeByName(cmd);
				log.log(Level.INFO, "employee with name " + cmd.getOptionValue("re") + " is removed");
			} else {
				log.log(Level.SEVERE, "MIssing v option");
				help();
			}

		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		}
	}

	private Department addEmployeeToDept(CommandLine cmd) {
		Employee employee = new Employee();
		DepartmentServiceImpl departmentService = AppContextHolder.getBean("departmentServiceImpl");
		Department department = departmentService.getDepartmentById(Integer.parseInt(cmd.getOptionValues("ae")[0]));
		employee.setFio(cmd.getOptionValues("ae")[1]);
		departmentService.addEmployee(department, employee);
		return department;
	}

	private void deleteEmployeeByName(CommandLine cmd) {
		EmployeeServiceImpl employeeService = AppContextHolder.getBean("employeeServiceImpl");
		employeeService.deleteEmployeesByName(cmd.getOptionValue("re"));
	}

	private Set<Employee> getEmployeeByDept(CommandLine cmd) {
		EmployeeServiceImpl employeeService = AppContextHolder.getBean("employeeServiceImpl");
		Set<Employee> employees = employeeService.getEmployeesByDepartment(Integer.parseInt(cmd.getOptionValue("fe")));
		return employees;
	}

	private Department findDept(CommandLine cmd) {
		DepartmentServiceImpl departmentService = AppContextHolder.getBean("departmentServiceImpl");
		Department department = departmentService.getDepartmentById(Integer.parseInt(cmd.getOptionValue("fn")));
		return department;
	}

	private List<Department> getAllDepts() {
		DepartmentServiceImpl departmentService = AppContextHolder.getBean("departmentServiceImpl");
		List<Department> departments = departmentService.getAllDepartments();
		return departments;
	}

	private DepartmentServiceImpl deleteDept(CommandLine cmd) {
		DepartmentServiceImpl departmentService = AppContextHolder.getBean("departmentServiceImpl");
		departmentService.deleteDepartment(Integer.parseInt(cmd.getOptionValue("rm")));
		return departmentService;
	}

	private Department modifyDept(CommandLine cmd) {
		DepartmentServiceImpl departmentService = AppContextHolder.getBean("departmentServiceImpl");
		Department department = departmentService.getDepartmentById(Integer.parseInt(cmd.getOptionValues("ed")[0]));
		department.setCaption(cmd.getOptionValues("ed")[1]);
		departmentService.editDepartment(department);
		return department;
	}

	private Department addDept(CommandLine cmd) {
		Department department = new Department();
		department.setCaption(cmd.getOptionValue("nd"));
		DepartmentServiceImpl departmentService = AppContextHolder.getBean("departmentServiceImpl");
		departmentService.addDepartment(department);
		return department;
	}

	private void help() {
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();

		formater.printHelp("Main", options);
		System.exit(0);
	}
}
