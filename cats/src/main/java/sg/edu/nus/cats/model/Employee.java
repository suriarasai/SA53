package sg.edu.nus.cats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee class
 *
 * @version $Revision: 1.0
 * @author Suria
 * 
 */

@Entity

@Table(name="employee")
@Data
@NoArgsConstructor
public class Employee implements Serializable {
	private static final long serialVersionUID = 6529685098267757670L;
    @Id
    @Column(name = "employeeid")
    private String employeeId;
    private String name;
    @Column(name = "managerid")
    private String managerId;

    public Employee(String employeeId,String name, String managerId){
    
    this.employeeId = employeeId;
    this.name = name;
    this.managerId = managerId;
    
    }
    
    public Employee (String employeeId) {
        setEmployeeId(employeeId);
    }

 }
