package sg.edu.nus.welcome.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;
    
    @OneToOne(cascade = {CascadeType.ALL})  
    @JoinColumn(name="PSPACE_ID") 
    private ParkingSpace parkingSpace;
    
    @ManyToOne
    private Department department;
    
    @ManyToMany 
    private Collection<Project> projects;

	public Employee(int id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Employee(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, long salary, ParkingSpace parkingSpace, Department department,
			Collection<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.parkingSpace = parkingSpace;
		this.department = department;
		this.projects = projects;
	}

	public Employee(String name, long salary, ParkingSpace parkingSpace, Department department,
			Collection<Project> projects) {
		super();
		this.name = name;
		this.salary = salary;
		this.parkingSpace = parkingSpace;
		this.department = department;
		this.projects = projects;
	}
	    
    
}
