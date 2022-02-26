package br.com.siscoe.siscoe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	
	private String type;
	
	private String cia = "";
	
	private int length;
	
	private int width;
	
	private int height;
	
	@ManyToOne
	private Encarregado encarregado;
	
	private int lastReform = 0;
	
	private int currentOccupation;
	
	private String ammunitionType = "";
	
	private Boolean open = false;
	
	private int totalOpenings = 0;
	
	@OneToOne
	private Encarregado lastEncarregoToOpen;
	
	private String seal = "";
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Encarregado getEncarregado() {
		return encarregado;
	}

	public void setEncarregado(Encarregado encarregado) {
		this.encarregado = encarregado;
	}

	public int getLastReform() {
		return lastReform;
	}

	public void setLastReform(int lastReform) {
		this.lastReform = lastReform;
	}

	public int getCurrentOccupation() {
		return currentOccupation;
	}

	public void setCurrentOccupation(int currentOccupation) {
		this.currentOccupation = currentOccupation;
	}

	public String getAmmunitionType() {
		return ammunitionType;
	}

	public void setAmmunitionType(String ammunitionType) {
		this.ammunitionType = ammunitionType;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public int getTotalOpenings() {
		return totalOpenings;
	}

	public void setTotalOpenings(int totalOpenings) {
		this.totalOpenings = totalOpenings;
	}

	public Encarregado getLastEncarregoToOpen() {
		return lastEncarregoToOpen;
	}

	public void setLastEncarregoToOpen(Encarregado lastEncarregoToOpen) {
		this.lastEncarregoToOpen = lastEncarregoToOpen;
	}

	public String getSeal() {
		return seal;
	}

	public void setSeal(String seal) {
		this.seal = seal;
	}
}
