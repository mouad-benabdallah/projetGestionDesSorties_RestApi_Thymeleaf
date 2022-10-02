package com.exo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role() {
		super();
	}
	
	
	

}
