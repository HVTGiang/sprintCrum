package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.findStudentByPerson", query = "SELECT s FROM Student s WHERE s.person = :person"),
        @NamedQuery(name = "Student.getStudentByPersonId", query = "SELECT s FROM Student s WHERE s.person.personId = :personId")
})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "major_id")
    private String majorId;

    @Column(name = "school_year")
    private String schoolYear;

    @Id
    @Column(name = "student_id")
    private String studentId;

    //bi-directional many-to-one association to Groupstudent
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groupstudent groupstudent;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Student() {
    }

    public String getMajorId() {
        return this.majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
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

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
