package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the account database table.
 */
@Entity
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
@NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a where a.username=:username")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_id")
    private String accountId;

    private String description;

    private String password;

    private String username;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Account() {
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}