package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the head_lecturer database table.
 * 
 */
@Entity
@Table(name="head_lecturer")
@NamedQuery(name="HeadLecturer.findAll", query="SELECT h FROM HeadLecturer h")
public class HeadLecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="headlecturer_id")
	private String headlecturerId;

	@Column(name="major_id")
	private String majorId;

	@Column(name="person_id")
	private String personId;

	public HeadLecturer() {
	}

	public String getHeadlecturerId() {
		return this.headlecturerId;
	}

	public void setHeadlecturerId(String headlecturerId) {
		this.headlecturerId = headlecturerId;
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}