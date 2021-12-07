package sg.edu.nus.welcome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
public class Customer implements Comparable<Customer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String name;
	private String address;
	
	public Customer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		if (this.customerId == o.getCustomerId()) 
			return 0;
			else 
		return -1;
	}
	
	
	
}
