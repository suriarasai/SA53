package sg.edu.nus.cats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User class
 *
 * @version $Revision: 1.0
 * @author Suria
 * 
 */

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 6529685098267757680L;
	@Id
	@Column(name = "userid")
	private String userId;
	@NotEmpty
	@Column(name = "name")
	private String name;
	@NotEmpty
	@Column(name = "password")
	private String password;
	@Column(name = "employeeid")
	private String employeeId;

	@ManyToMany(targetEntity = Role.class, cascade = {CascadeType.ALL, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinTable(name = "userrole", joinColumns = {
			@JoinColumn(name = "userid", referencedColumnName = "userid") }, inverseJoinColumns = {
					@JoinColumn(name = "roleid", referencedColumnName = "roleid") }

	)
	private List<Role> roleSet;
	
	@Transient
	private ArrayList<String> roleIds = new ArrayList<String>();

	public User(String userId, String name, String password, String employeeId) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.employeeId = employeeId;
	}

	public User(String userId) {
		this.userId = userId;
	}

}