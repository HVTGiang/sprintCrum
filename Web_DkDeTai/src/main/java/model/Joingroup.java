package model;

import javax.persistence.*;

@Entity
@IdClass(JoingroupPK.class)
public class Joingroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "group_id")
    private String groupId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private String studentId;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, updatable = false, insertable = false)
    private Groupstudent groupstudentByGroupId;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false, updatable = false, insertable = false)
    private Student studentByStudentId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Joingroup joingroup = (Joingroup) o;

        if (groupId != null ? !groupId.equals(joingroup.groupId) : joingroup.groupId != null) return false;
        if (studentId != null ? !studentId.equals(joingroup.studentId) : joingroup.studentId != null) return false;
        if (status != null ? !status.equals(joingroup.status) : joingroup.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public Groupstudent getGroupstudentByGroupId() {
        return groupstudentByGroupId;
    }

    public void setGroupstudentByGroupId(Groupstudent groupstudentByGroupId) {
        this.groupstudentByGroupId = groupstudentByGroupId;
    }

    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
