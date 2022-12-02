package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groupstudent database table.
 * 
 */
@Entity
@NamedQuery(name="Groupstudent.findAll", query="SELECT g FROM Groupstudent g")
public class Groupstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_id")
	private String groupId;

	@Column(name="current_number")
	private int currentNumber;

	private String description;

	@Column(name="is_full")
	private byte isFull;

	@Column(name="leader_id")
	private String leaderId;

	@Column(name="topic_id")
	private String topicId;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="groupstudent")
	private List<Student> students;

	public Groupstudent() {
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public int getCurrentNumber() {
		return this.currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
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

	public String getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setGroupstudent(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setGroupstudent(null);

		return student;
	}

}