package sg.edu.nus.welcome.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer implements Comparable<Customer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Collection<Address> address = new HashSet<Address>();

	@Column(unique = true)
	private EmailAddress emailAddress;

	public Customer(String name, String a) {
		super();
		this.name = name;
		Address address = new Address(a, "AAA", "BB");
		HashSet<Address> aset = new HashSet<Address>();
		aset.add(address);
		this.address = aset;
	}

	public Customer(String name, HashSet<Address> address) {
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
