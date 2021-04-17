package pa3.employee;

import java.util.ArrayList;

public class Employee {

	private String firstName;
	private String lastName;
	private double salary;

	public Employee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public String displayInfo() {
		return String.format("FirstName: %s%nLastName: %s%n;Salary: %.2f", firstName, lastName, salary);
	}
	
}

class EmployeeTest {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("a", "a", 1000));
		employees.add(new Employee("b", "b", 1100));
		employees.add(new Employee("b", "c", 1200));
		
		employees.forEach(x -> System.out.println(x.displayInfo()));
	}
}
