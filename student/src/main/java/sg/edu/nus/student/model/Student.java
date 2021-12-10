package sg.edu.nus.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@NotEmpty
	@Size(min=3, max=10)
	private String name;
	@Length(max=20)
	private String nick;
	private Double cap;
	private Double fee;
	private Track track;
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date enrolledOn;
	public Student(String name, String nick, Double cap, Double fee) {
		super();
		this.name = name;
		this.nick = nick;
		this.cap = cap;
		this.fee = fee;
	}
	public Student(String name, String nick, Double cap, Double fee, Track track, Date enrolledOn) {
		super();
		this.name = name;
		this.nick = nick;
		this.cap = cap;
		this.fee = fee;
		this.track=track;
		this.enrolledOn = enrolledOn;
	}

	

}
