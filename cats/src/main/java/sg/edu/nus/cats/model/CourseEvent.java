package sg.edu.nus.cats.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.edu.nus.cats.helper.CourseEventEnum;

/**
 * CourseEvent class
 *
 * @version $Revision: 1.0
 * @author Suria
 * 
 */

@Entity
@Table(name = "courseevent")
@Data
@NoArgsConstructor
public class CourseEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseeventid")
	private int courseEventId;
	@Temporal(TemporalType.DATE)
	@Column(name = "timestamp")
	private Date timeStamp;
	@Column(name = "eventtype", columnDefinition = "ENUM('SUBMITTED', 'APPROVED', 'WITHDRAWN', 'UPDATED', 'REJECTED')")
	@Enumerated(EnumType.STRING)
	private CourseEventEnum eventType;
	@Column(name = "eventby")
	private String eventBy;
	@Column(name = "comment")
	private String comment;
	// Reverse Relation
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "courseid")
	private Course course;


	public CourseEvent(int courseEventId, Date timeStamp, CourseEventEnum eventType, String eventBy, String comment,
			Course course) {
		super();
		this.courseEventId = courseEventId;
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.eventBy = eventBy;
		this.comment = comment;
		this.course = course;
	}
	
	

}
