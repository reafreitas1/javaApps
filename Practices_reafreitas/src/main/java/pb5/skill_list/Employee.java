package pb5.skill_list;

public class Employee {
	
	protected static int employeeIdCounter = 0;
	
	public int employeeId;
	public String name;
	public String jobTitle;
	public int level;

	public int getEmployeeId() {
		return employeeId;
	}

	private void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void calculateEmployeeId() {
		setEmployeeId(++employeeIdCounter); 
	}
	
	public void displayInformation() {
		System.out.printf("ID: %d; Name: %s;%nJobTitle: %s; Level: %d", employeeId, name, jobTitle, level);
	}
}