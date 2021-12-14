package sg.edu.nus.cats.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Department class
 *
 * @version $Revision: 1.0
 * @author Suria
 * 
 */

@Entity
@Table(name="department")
@Data
@NoArgsConstructor
public class Department {
	@Id
	@Column(name = "departmentid")
	private String departmentId;
	@Basic
	@Column(name = "managerid")
	private String managerInCharge;

	public Department(String departmentId) {
		this.setDepartmentId(departmentId);
	}

}
