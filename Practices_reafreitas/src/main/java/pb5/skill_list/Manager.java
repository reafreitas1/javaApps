package pb5.skill_list;

import java.util.ArrayList;

public class Manager extends Employee {

	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	public void setEmployee(Employee emp) {
		employeeList.add(emp);
	}
	
	public ArrayList<Employee> getEmployees(){
		return employeeList;
	}

	@Override
	public void displayInformation() {
		super.displayInformation();
		System.out.printf("Manager has the following employees: $s", employeeList);
	}
	
}
