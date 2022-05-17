package br.com.siscoe.siscoe.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	
	private String type;
	
	private Cia cia;
	
	private int length;
	
	private int width;
	
	private int height;
	
	@ManyToOne
	private Encarregado encarregado;
	
	private int lastReform = 0;
	
	private int currentOccupation;
	
	private String ammunitionType;
	
	private Boolean open = false;
	
	private int totalOpenings = 0;
	
	@OneToOne
	private Encarregado lastEncarregoToOpen;
	
	private String seal;
	
	public Building() {}

	public Building(String number, String type, int length, int width, int height, int currentOccupation) {
		super();
		this.number = number;
		this.type = type;
		this.length = length;
		this.width = width;
		this.height = height;
		this.currentOccupation = currentOccupation;
	}

}
