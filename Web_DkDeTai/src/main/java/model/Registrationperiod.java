package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Registrationperiod {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "registration_period_id")
    private String registrationPeriodId;
    @Basic
    @Column(name = "registration_period_name")
    private String registrationPeriodName;
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "semeter")
    private Integer semeter;
    @Basic
    @Column(name = "school_year")
    private Integer schoolYear;
    @Basic
    @Column(name = "is_registration_lecturer")
    private boolean isRegistrationLecturer;
    @Basic
    @Column(name = "open_date")
    private Timestamp openDate;
    @Basic
    @Column(name = "close_date")
    private Timestamp closeDate;
    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public String getRegistrationPeriodId() {
        return registrationPeriodId;
    }

    public void setRegistrationPeriodId(String registrationPeriodId) {
        this.registrationPeriodId = registrationPeriodId;
    }

    public String getRegistrationPeriodName() {
        return registrationPeriodName;
    }

    public void setRegistrationPeriodName(String registrationPeriodName) {
        this.registrationPeriodName = registrationPeriodName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSemeter() {
        return semeter;
    }

    public void setSemeter(Integer semeter) {
        this.semeter = semeter;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public boolean isRegistrationLecturer() {
        return isRegistrationLecturer;
    }

    public void setRegistrationLecturer(boolean registrationLecturer) {
        isRegistrationLecturer = registrationLecturer;
    }

    public Timestamp getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Timestamp openDate) {
        this.openDate = openDate;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registrationperiod that = (Registrationperiod) o;

        if (isRegistrationLecturer != that.isRegistrationLecturer) return false;
        if (registrationPeriodId != null ? !registrationPeriodId.equals(that.registrationPeriodId) : that.registrationPeriodId != null)
            return false;
        if (registrationPeriodName != null ? !registrationPeriodName.equals(that.registrationPeriodName) : that.registrationPeriodName != null)
            return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (semeter != null ? !semeter.equals(that.semeter) : that.semeter != null) return false;
        if (schoolYear != null ? !schoolYear.equals(that.schoolYear) : that.schoolYear != null) return false;
        if (openDate != null ? !openDate.equals(that.openDate) : that.openDate != null) return false;
        if (closeDate != null ? !closeDate.equals(that.closeDate) : that.closeDate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = registrationPeriodId != null ? registrationPeriodId.hashCode() : 0;
        result = 31 * result + (registrationPeriodName != null ? registrationPeriodName.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (semeter != null ? semeter.hashCode() : 0);
        result = 31 * result + (schoolYear != null ? schoolYear.hashCode() : 0);
        result = 31 * result + (isRegistrationLecturer ? 1 : 0);
        result = 31 * result + (openDate != null ? openDate.hashCode() : 0);
        result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

}
