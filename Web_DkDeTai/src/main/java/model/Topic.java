package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Column(name="is_full")
	private byte isFull;

	@Column(name="is_selected")
	private byte isSelected;

	@Column(name="lecturer_id")
	private String lecturerId;

	@Column(name="max_mo_member")
	private int maxMoMember;

	private byte status;

	@Column(name="student_id")
	private String studentId;

	@Column(name="topic_id")
	private String topicId;

	@Column(name="topic_name")
	private String topicName;

	public Topic() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsFull() {
		return this.isFull;
	}

	public void setIsFull(byte isFull) {
		this.isFull = isFull;
	}

	public byte getIsSelected() {
		return this.isSelected;
	}

	public void setIsSelected(byte isSelected) {
		this.isSelected = isSelected;
	}

	public String getLecturerId() {
		return this.lecturerId;
	}

	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}

	public int getMaxMoMember() {
		return this.maxMoMember;
	}

	public void setMaxMoMember(int maxMoMember) {
		this.maxMoMember = maxMoMember;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}