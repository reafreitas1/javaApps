package pb5.skill_list;

public class Editor extends SkilledEmployee {

	private boolean prefersPaperEditing;

	public String getEditingPreferences() {
		return prefersPaperEditing ? "Paper" : "Electronic";
	}

	public void setPrefersPaperEditing(boolean prefersPaperEditing) {
		this.prefersPaperEditing = prefersPaperEditing;
	}

	@Override
	public void displayInformation() {
		super.displayInformation();
		System.out.printf("Paper Editing: %s", getEditingPreferences());
	}
}