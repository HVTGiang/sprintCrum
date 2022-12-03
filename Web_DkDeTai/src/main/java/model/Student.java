package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="major_id")
	private String majorId;

	@Column(name="person_id")
	private String personId;

	@Column(name="school_year")
	private String schoolYear;

	@Id
	@Column(name="student_id")
	private String studentId;

	//bi-directional many-to-one association to Groupstudent
	@ManyToOne
	@JoinColumn(name="group_id")
	private Groupstudent groupstudent;

	public Student() {
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

	public String getSchoolYear() {
		return this.schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Groupstudent getGroupstudent() {
		return this.groupstudent;
	}

	public void setGroupstudent(Groupstudent groupstudent) {
		this.groupstudent = groupstudent;
	}

}