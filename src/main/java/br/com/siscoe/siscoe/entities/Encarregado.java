package br.com.siscoe.siscoe.entities;

import java.util.ArrayList;
import java.util.List;

public class Encarregado {
	
	private Long id;
	
	private String login;
	
	private String password;
	
	private List<Role> roles = new ArrayList<Role>();
	
	private String cia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}
}
