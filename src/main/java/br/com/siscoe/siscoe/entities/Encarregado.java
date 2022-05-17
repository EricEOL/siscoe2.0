package br.com.siscoe.siscoe.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class Encarregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Cia cia;
	
	@OneToMany(mappedBy = "encarregado")
	private List<Building> paiois = new ArrayList<>();
	
	private int totalOpenings;

	public Encarregado(String name, Cia cia) {
		this.name = name;
		this.cia = cia;
	}
}
