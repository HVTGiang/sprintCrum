package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQuery(name = "Committe.findAll", query = "SELECT c FROM Committe c")
@NamedQuery(name = "Committee.findCommitteeByName", query = "SELECT c from Committe c where committeName=:name")
@NamedQuery(name = "Committee.findListByName", query = "SELECT c from Committe c where committeName like :name")
public class Committe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "committe_id")
    private String committeId;

    @Column(name = "committe_name")
    private String committeName;

    private String description;

    private Date reportDate;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Column(name = "num_member")
    private int numMember;

    //bi-directional many-to-one association to LecturerCommitte
    @OneToMany(mappedBy = "committe")
    private List<LecturerCommitte> lecturerCommittes;

    public Committe() {
    }

    public String getCommitteId() {
        return this.committeId;
    }

    public void setCommitteId(String committeId) {
        this.committeId = committeId;
    }

    public String getCommitteName() {
        return this.committeName;
    }

    public void setCommitteName(String committeName) {
        this.committeName = committeName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumMember() {
        return this.numMember;
    }

    public void setNumMember(int numMember) {
        this.numMember = numMember;
    }

    public List<LecturerCommitte> getLecturerCommittes() {
        return this.lecturerCommittes;
    }

    public void setLecturerCommittes(List<LecturerCommitte> lecturerCommittes) {
        this.lecturerCommittes = lecturerCommittes;
    }

    public LecturerCommitte addLecturerCommitte(LecturerCommitte lecturerCommitte) {
        getLecturerCommittes().add(lecturerCommitte);
        lecturerCommitte.setCommitte(this);

        return lecturerCommitte;
    }

    public LecturerCommitte removeLecturerCommitte(LecturerCommitte lecturerCommitte) {
        getLecturerCommittes().remove(lecturerCommitte);
        lecturerCommitte.setCommitte(null);

        return lecturerCommitte;
    }
}
