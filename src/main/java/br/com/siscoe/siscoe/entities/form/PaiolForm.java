package br.com.siscoe.siscoe.entities.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.siscoe.siscoe.entities.Paiol;

public class PaiolForm {
	
	@NotNull @NotEmpty
	private int number;
	
	@NotNull @NotEmpty
	private String type;
	
	@NotNull @NotEmpty
	private int length;
	
	@NotNull @NotEmpty
	private int width;
	
	@NotNull @NotEmpty
	private int height;
	
	@NotNull @NotEmpty
	private int currentOccupation = 0;
	
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
