package br.com.siscoe.siscoe.entities.dto;

import org.springframework.data.domain.Page;

import br.com.siscoe.siscoe.entities.Paiol;

public class PaiolDTO {
	
	private Long id;
	
	private String number;
	
	private String type;
	
	private String cia;
	
	private int length;
	
	private int width;
	
	private int height;
	
	private String encarregadoName;
	
	private int lastReform;
	
	private int currentOccupation;
	
	private String ammunitionType;

	public PaiolDTO(Paiol paiol) {
		this.id = paiol.getId();
		this.number = paiol.getNumber();
		this.type = paiol.getType();
		this.cia = paiol.getCia();
		this.length = paiol.getLength();
		this.width = paiol.getWidth();
		this.height = paiol.getHeight();
		
		if(paiol.getEncarregado() != null) {
			this.encarregadoName = paiol.getEncarregado().getName();
		} else {
			this.encarregadoName = null;
		}
		
		this.lastReform = paiol.getLastReform();
		this.currentOccupation = paiol.getCurrentOccupation();
		this.ammunitionType = paiol.getAmmunitionType();
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public String getCia() {
		return cia;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getEncarregadoName() {
		return encarregadoName;
	}

	public int getLastReform() {
		return lastReform;
	}

	public int getCurrentOccupation() {
		return currentOccupation;
	}

	public String getAmmunitionType() {
		return ammunitionType;
	}
	
	public static Page<PaiolDTO> transform(Page<Paiol> paiois) {
		return paiois.map(PaiolDTO::new);
	}
}
