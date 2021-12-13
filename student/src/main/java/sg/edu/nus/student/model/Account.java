package sg.edu.nus.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
	private Double balance;
	private String name;
	public Account(Double balance, String name) {
		super();
		this.balance = balance;
		this.name = name;
	}
	public Account(Integer accountNumber, Double balance, String name) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.name = name;
	}
	
	
	
}
