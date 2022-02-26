package br.com.siscoe.siscoe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Encarregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cia;
	
	@OneToMany(mappedBy = "encarregado")
	private List<Building> paiois = new ArrayList<>();
	
	private int totalOpenings;

	public Encarregado() {}
	
	public Encarregado(String name, String cia) {
		this.name = name;
		this.cia = cia;
	}

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

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}

	public List<Building> getPaiois() {
		return paiois;
	}

	public void setPaiois(List<Building> paiois) {
		this.paiois = paiois;
	}

	public int getTotalOpenings() {
		return totalOpenings;
	}

	public void setTotalOpenings(int totalOpenings) {
		this.totalOpenings = totalOpenings;
	}
}
