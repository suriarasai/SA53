package sg.edu.nus.student.model;


public enum Track {
	
	SA("System Analysis"),
	SE("Software Engineering"),
	IS("Intelligent Systems"),
	EBAC("Enterprise Business Analytics");
	
	private final String displayValue;
	
	private Track(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}

}
