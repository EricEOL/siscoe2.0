package br.com.siscoe.siscoe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Encarregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Cia cia;
	
	private List<Paiol> paiois = new ArrayList<Paiol>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cia getCia() {
		return cia;
	}

	public void setCia(Cia cia) {
		this.cia = cia;
	}

	public List<Paiol> getPaiois() {
		return paiois;
	}

	public void setPaiois(List<Paiol> paiois) {
		this.paiois = paiois;
	}
}
