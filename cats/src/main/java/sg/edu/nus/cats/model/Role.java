package sg.edu.nus.cats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Course class
 *
 * @version $Revision: 1.0
 * @author Suria
 * 
 */

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role implements Serializable {
	
	private static final long serialVersionUID = 6529685098267757690L;
	@Id
	@Column(name = "roleid")
	private String roleId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
   	public Role(String roleId, String name, String description) {

		this.roleId = roleId;
		this.name = name;
		this.description = description;

	}
	public Role(String roleId) {
		this.roleId = roleId;
	}
}