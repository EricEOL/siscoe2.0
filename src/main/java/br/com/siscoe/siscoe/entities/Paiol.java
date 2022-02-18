package br.com.siscoe.siscoe.entities;

public class Paiol {
	
	private Long id;
	
	private int number;
	
	private String type;
	
	private String cia;
	
	private String length;
	
	private String width;
	
	private String height;
	
	private Encarregado encarregado;
	
	private int lastReform;
	
	private int currentOccupation;
	
	private String ammunitionType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
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
}
