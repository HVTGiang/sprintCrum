package model;

import javax.persistence.*;

@Entity
public class Headlecturer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "headlecturer_id")
    private String headlecturerId;
    @Basic
    @Column(name = "person_id")
    private String personId;
    @Basic
    @Column(name = "major_id")
    private String majorId;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", updatable = false, insertable = false)
    private Person personByPersonId;
    @ManyToOne
    @JoinColumn(name = "major_id", referencedColumnName = "major_id", updatable = false, insertable = false)
    private Major majorByMajorId;

    public String getHeadlecturerId() {
        return headlecturerId;
    }

    public void setHeadlecturerId(String headlecturerId) {
        this.headlecturerId = headlecturerId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Headlecturer that = (Headlecturer) o;

        if (headlecturerId != null ? !headlecturerId.equals(that.headlecturerId) : that.headlecturerId != null)
            return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (majorId != null ? !majorId.equals(that.majorId) : that.majorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = headlecturerId != null ? headlecturerId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (majorId != null ? majorId.hashCode() : 0);
        return result;
    }

    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    public Major getMajorByMajorId() {
        return majorByMajorId;
    }

    public void setMajorByMajorId(Major majorByMajorId) {
        this.majorByMajorId = majorByMajorId;
    }
}
