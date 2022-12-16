package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "notification_id")
    private String notificationId;
    @Basic
    @Column(name = "notification_title")
    private String notificationTitle;
    @Basic
    @Column(name = "sender_id")
    private String senderId;
    @Basic
    @Column(name = "receiver_id")
    private String receiverId;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "person_id", updatable = false, insertable = false)
    private Person personBySenderId;
    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "person_id", updatable = false, insertable = false)
    private Person personByReceiverId;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (notificationId != null ? !notificationId.equals(that.notificationId) : that.notificationId != null)
            return false;
        if (notificationTitle != null ? !notificationTitle.equals(that.notificationTitle) : that.notificationTitle != null)
            return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        if (receiverId != null ? !receiverId.equals(that.receiverId) : that.receiverId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = notificationId != null ? notificationId.hashCode() : 0;
        result = 31 * result + (notificationTitle != null ? notificationTitle.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (receiverId != null ? receiverId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public Person getPersonBySenderId() {
        return personBySenderId;
    }

    public void setPersonBySenderId(Person personBySenderId) {
        this.personBySenderId = personBySenderId;
    }

    public Person getPersonByReceiverId() {
        return personByReceiverId;
    }

    public void setPersonByReceiverId(Person personByReceiverId) {
        this.personByReceiverId = personByReceiverId;
    }
}
