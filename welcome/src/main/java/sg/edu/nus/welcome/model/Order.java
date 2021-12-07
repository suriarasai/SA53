package sg.edu.nus.welcome.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="orders")
@NoArgsConstructor
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@ManyToOne(optional = false)
	private Customer customer;

	@ManyToOne(optional = true)
	private Address billingAddress;

	@ManyToOne(optional = true)
	private Address shippingAddress;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orderId")
	private Set<LineItem> lineItems = new HashSet<LineItem>();

	public Order(Customer customer, Address billingAddress, Address shippingAddress, Set<LineItem> lineItems) {
		super();
		this.customer = customer;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.lineItems = lineItems;
	}

	
}
