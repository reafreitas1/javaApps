package pb5.skill_list;

import java.util.ArrayList;

public class SkilledEmployee extends Employee {

	ArrayList<String> skillList = new ArrayList<>();
	
	public void setSkill(String skill) {
		skillList.add(skill);
	}
	
	public ArrayList<String> getSkills(){
		return skillList;
	}

	@Override
	public void displayInformation() {
		super.displayInformation();
		System.out.printf("Employee has the following skills %s", skillList);
	}
}