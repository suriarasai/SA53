package sg.edu.nus.welcome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="lineitem")
@Data
@NoArgsConstructor
public class LineItem {
	@Id
	private Integer lineItemId;
	@ManyToOne
	private Product product;
	@Column(nullable = false)
	private Double price;
	private Double amount;
	public LineItem(Product product, Double price, Double amount) {
		super();
		this.product = product;
		this.price = price;
		this.amount = amount;
	}
	
}
