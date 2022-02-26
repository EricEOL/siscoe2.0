package br.com.siscoe.siscoe.entities.form.building;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.siscoe.siscoe.entities.Building;

public class BuildingForm {
	
	@NotNull
	private String number;
	
	@NotNull @NotEmpty
	private String type;
	
	@NotNull 
	private int length;
	
	@NotNull
	private int width;
	
	@NotNull 
	private int height;
	
	@NotNull
	private int currentOccupation = 0;
	
	public void setNumber(String number) {
		this.number = number;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setCurrentOccupation(int currentOccupation) {
		this.currentOccupation = currentOccupation;
	}

	public Building transform() {
		return new Building(number, type, length, width, height, currentOccupation);
	}
	
}
