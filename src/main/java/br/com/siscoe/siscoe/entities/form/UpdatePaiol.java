package br.com.siscoe.siscoe.entities.form;

import br.com.siscoe.siscoe.entities.Cia;
import br.com.siscoe.siscoe.entities.Encarregado;
import br.com.siscoe.siscoe.entities.Paiol;
import br.com.siscoe.siscoe.repositories.PaiolRepository;

public class UpdatePaiol {

	private String cia;
	private String encarregado;
	private int lastReform;
	private int currentOccupation;
	private String ammunitionType;
	
	public Cia getCia() {
		return cia;
	}
	public void setCia(Cia cia) {
		this.cia = cia;
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
	public Paiol transform(Long id, PaiolRepository paiolRepository) {
		
		Paiol paiol = paiolRepository.getById(id);
		
		paiol.setCia(cia);
		paiol.setEncarregado(encarregado);
		paiol.setLastReform(lastReform);
		paiol.setCurrentOccupation(currentOccupation);
		paiol.setAmmunitionType(ammunitionType);
		
		return paiol;
	}

}
