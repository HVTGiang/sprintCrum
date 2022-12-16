package model;

import javax.persistence.*;

@Entity
@Table(name = "lecturer_critical", schema = "dkdetai", catalog = "")
public class LecturerCritical {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lecturer_id")
    private String lecturerId;
    @Basic
    @Column(name = "person_id")
    private String personId;
    @OneToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id", nullable = false)
    private Lecturer lecturerByLecturerId;

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LecturerCritical that = (LecturerCritical) o;

        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lecturerId != null ? lecturerId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }

    public Lecturer getLecturerByLecturerId() {
        return lecturerByLecturerId;
    }

    public void setLecturerByLecturerId(Lecturer lecturerByLecturerId) {
        this.lecturerByLecturerId = lecturerByLecturerId;
    }
}
