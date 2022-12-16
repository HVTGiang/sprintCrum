package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the person database table.
 *
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
@NamedQuery(name="Person.findByPhone", query = "SELECT p from Person p where phonenumber=:phone")
@NamedQuery(name="Person.findByMail", query = "SELECT p from Person p where email=:mail")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="person_id")
    private String personId;

    private String address;

    private String description;

    private String email;

    @Column(name="full_name")
    private String fullName;

    private byte gender;

    private String phonenumber;

    private String role;

    //bi-directional many-to-one association to Account
    @OneToMany(mappedBy="person")
    private List<Account> accounts;

    //bi-directional many-to-one association to Admin
    @OneToMany(mappedBy="person")
    private List<Admin> admins;

    public Person() {
    }

    public String getPersonId() {
        return this.personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public byte getGender() {
        return this.gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account addAccount(Account account) {
        getAccounts().add(account);
        account.setPerson(this);

        return account;
    }

    public Account removeAccount(Account account) {
        getAccounts().remove(account);
        account.setPerson(null);

        return account;
    }

    public List<Admin> getAdmins() {
        return this.admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public Admin addAdmin(Admin admin) {
        getAdmins().add(admin);
        admin.setPerson(this);

        return admin;
    }

    public Admin removeAdmin(Admin admin) {
        getAdmins().remove(admin);
        admin.setPerson(null);

        return admin;
    }

}