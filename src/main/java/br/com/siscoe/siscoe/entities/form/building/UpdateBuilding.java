package br.com.siscoe.siscoe.entities.form.building;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.siscoe.siscoe.entities.Encarregado;
import br.com.siscoe.siscoe.entities.Building;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;
import br.com.siscoe.siscoe.repositories.BuildingRepository;

public class UpdateBuilding {

	@NotNull @NotEmpty
	private String cia;
	
	@NotNull @NotEmpty
	private String encarregado;
	
	@NotNull @NotEmpty
	private int lastReform;
	
	@NotNull @NotEmpty
	private int currentOccupation;
	
	@NotNull @NotEmpty
	private String ammunitionType;

	public String getCia() {
		return cia;
	}
	public void setCia(String cia) {
		this.cia = cia;
	}
	public String getEncarregado() {
		return encarregado;
	}
	public void setEncarregado(String encarregado) {
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
	public Building transform(Long id, BuildingRepository paiolRepository, EncarregadoRepository encarregadoRepository) {
		
		Building paiol = paiolRepository.getById(id);
		
		Optional<Encarregado> encarregadoFound = encarregadoRepository.findByName(encarregado);
		
		if(encarregadoFound.isPresent()) {
			paiol.setEncarregado(encarregadoFound.get());
		}
		
		paiol.setCia(cia);
		paiol.setLastReform(lastReform);
		paiol.setCurrentOccupation(currentOccupation);
		paiol.setAmmunitionType(ammunitionType);
		
		return paiol;
	}

}
