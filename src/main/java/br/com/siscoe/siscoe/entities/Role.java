package br.com.siscoe.siscoe.entities;

public class Role {

	private Long id;
	
	private RoleNames name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleNames getName() {
		return name;
	}

	public void setName(RoleNames name) {
		this.name = name;
	}

}
