package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lecturer database table.
 * 
 */
@Entity
@NamedQuery(name="Lecturer.findAll", query="SELECT l FROM Lecturer l")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="is_head")
	private byte isHead;

	@Column(name="lecturer_id")
	private String lecturerId;

	@Column(name="major_id")
	private String majorId;

	@Column(name="person_id")
	private String personId;

	public Lecturer() {
	}

	public byte getIsHead() {
		return this.isHead;
	}

	public void setIsHead(byte isHead) {
		this.isHead = isHead;
	}

	public String getLecturerId() {
		return this.lecturerId;
	}

	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
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