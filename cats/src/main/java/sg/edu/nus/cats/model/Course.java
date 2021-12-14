package sg.edu.nus.cats.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.edu.nus.cats.helper.CourseEventEnum;

/**
 * Course class
 *
 * @version $Revision: 1.0
 * @author Suria
 * 
 */

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
public class Course {

	/** Attributes for Course **/
	@Id
	@Column(name = "courseid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	@Basic
	@Column(name = "employeeid")
	private String employeeId;
	@Column(name = "coursename")
	private String courseName;
	@Column(name = "organiser")
	private String organiser;
	@Temporal(TemporalType.DATE)
	@Column(name = "fromdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "todate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date toDate;
	@Basic
	@Column(name = "fees")
	private double fees;
	@Basic
	@Column(name = "gstincluded", columnDefinition = "BIT", length = 1)
	private boolean gstIncluded;
	@Basic
	@Column(name = "justification")
	private String justification;
	@Column(name = "status", columnDefinition = "ENUM('SUBMITTED', 'APPROVED', 'WITHDRAWN', 'UPDATED', 'REJECTED')")
	@Enumerated(EnumType.STRING)
	private CourseEventEnum status;

	/** Container for CourseApplicationActions **/
	@OneToMany(mappedBy = "course", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Collection<CourseEvent> courseEvent = new ArrayList<CourseEvent>();

	public Course(int courseId) {
		this.courseId = courseId;
	}
	
	

	public Course(int courseId, String employeeId, String courseName, String organiser, Date fromDate, Date toDate,
			double fees, boolean gstIncluded, String justification, CourseEventEnum status,
			ArrayList<CourseEvent> events) {
		super();
		this.courseId = courseId;
		this.employeeId = employeeId;
		this.courseName = courseName;
		this.organiser = organiser;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fees = fees;
		this.gstIncluded = gstIncluded;
		this.justification = justification;
		this.status = status;
		this.courseEvent.addAll(events);
	}
	
	public void addCourseEvent(CourseEvent ce) {
		this.courseEvent.add(ce);
	}
	
}
