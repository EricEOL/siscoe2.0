package br.com.siscoe.siscoe.entities.dto;

import br.com.siscoe.siscoe.entities.Paiol;

public class PaiolForm {
	
	private int number;
	private String type;
	private int length;
	private int width;
	private int height; 
	private int currentOccupation;
	
	public void setNumber(int number) {
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

	public Paiol transform() {
		return new Paiol(number, type, length, width, height, currentOccupation);
	}
	
}
