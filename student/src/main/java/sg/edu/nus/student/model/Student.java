package sg.edu.nus.student.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	private String nick;
	private Double cap;
	private Double fee;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String nick, Double cap, Double fee) {
		super();
		this.name = name;
		this.nick = nick;
		this.cap = cap;
		this.fee = fee;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Double getCap() {
		return cap;
	}
	public void setCap(Double cap) {
		this.cap = cap;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentId == other.studentId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", nick=" + nick + ", cap=" + cap + ", fee=" + fee
				+ "]";
	}
	

}
