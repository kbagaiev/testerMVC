package com.bagaiev.entities;

import com.bagaiev.entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the role database table.
 *
 */
@Entity
@Table(name="role")
public class Role extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="ROLE_IDROLE_GENERATOR", sequenceName="ROLE_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_IDROLE_GENERATOR")
    @Column(name="id_role", unique=true, nullable=false)
    private Long idRole;

    @Column(nullable=false, length=15)
    private String name;


	//bi-directional many-to-one association to AccountRole
	@OneToMany(mappedBy="role")
	private List<AccountRole> accountRoles;


    public Role() {
    }

    public Long getIdRole() {
        return this.idRole;
    }

    @Override
    @Transient
    public Serializable getId() {
        return getIdRole();
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<AccountRole> getAccountRoles() {
		return this.accountRoles;
	}

	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

}