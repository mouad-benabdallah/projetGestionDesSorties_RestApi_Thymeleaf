package com.exo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String rolesadmin="";
	@Id
	@NotBlank
	private String login;
	@Column(columnDefinition = "integer default 1")
	private int active;
	@NotBlank
	private String password;
	@Column(nullable = false,unique = true)
	@Size(min = 4,max = 50)
	private String nomComplet;
	private String adresse;
	private String telephone;
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<Role>();
	
	
	public String getRolesadmin() {
		String admineroles="";
		for(Role r:roles) {
			admineroles=admineroles+" "+r.getRoleName();
		}
		rolesadmin=admineroles;
		return rolesadmin;	
	}
	
	public static void setRolesadmin(String rolesadmin) {
		Admin.rolesadmin = rolesadmin;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Admin(@NotBlank String login, int active, @NotBlank String password, @Size(min = 4, max = 50) String nomComplet,
			String adresse, String telephone, Collection<Role> roles) {
		super();
		this.login = login;
		this.active = active;
		this.password = password;
		this.nomComplet = nomComplet;
		this.adresse = adresse;
		this.telephone = telephone;
		this.roles = roles;
	}

	public Admin() {
		super();
	}
	

	
	
	
	
	

}
