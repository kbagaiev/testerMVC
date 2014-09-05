package com.bagaiev.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Table(name="account")
public class Account extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="ACCOUNT_IDACCOUNT_GENERATOR", sequenceName="ACCOUNT_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_IDACCOUNT_GENERATOR")
    @Column(name="id_account", unique=true, nullable=false)
    private Long idAccount;

    @Column(nullable=false)
    private Boolean active;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
    private Date created = new Date();

    @Column(nullable=false, length=100)
    private String email;

    @Column(nullable=false, length=60)
    private String login;

    @Column(nullable=false, length=255)
    private String password;

    @Column(name="first_name", length=80)
    private String firstName;

    @Column(name="last_name", length=80)
    private String secondName;

    @Column(name="middle_name",length=80)
    private String middleName;

    private Timestamp updated;

    //bi-directional many-to-one association to AccountRole
    @OneToMany(mappedBy="account")
    private List<AccountRole> accountRoles;

    /*
    //bi-directional many-to-one association to PassedTest
    @OneToMany(mappedBy="account")
    private List<PassedTest> passedTests;

    //bi-directional many-to-one association to Test
    @OneToMany(mappedBy="account")
    private List<Test> tests;
     */
    public Account() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getIdAccount() {
        return this.idAccount;
    }

    @Override
    @Transient
    public Serializable getId() {
        return getIdAccount();
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreated() {

        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Timestamp getUpdated() {
        return this.updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public List<AccountRole> getAccountRoles() {
        return this.accountRoles;
    }

    public void setAccountRoles(List<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

	/*public List<PassedTest> getPassedTests() {
		return this.passedTests;
	}

	public void setPassedTests(List<PassedTest> passedTests) {
		this.passedTests = passedTests;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}*/

}