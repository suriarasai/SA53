package sg.edu.nus.welcome.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String name;
	private String major;
	private Double cap;
	public Student(String name, String major, Double cap) {
		super();
		this.name = name;
		this.major = major;
		this.cap = cap;
	}
	
	

}
