package br.com.siscoe.siscoe.entities.form.paiol;

import java.util.Optional;

import br.com.siscoe.siscoe.entities.Building;
import br.com.siscoe.siscoe.entities.Encarregado;
import br.com.siscoe.siscoe.repositories.BuildingRepository;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;

public class FormUpdateSealAndLastEncarregadoToOpen {

	private String seal;
	private String encarregadoName;
	
	public String getSeal() {
		return seal;
	}

	public String getEncarregadoName() {
		return encarregadoName;
	}

	public Building transform(Long id, BuildingRepository buildingRepository, EncarregadoRepository encarregadoRepository) {
		
		Building paiol = buildingRepository.getById(id);
		Optional<Encarregado> encarregadoExists = encarregadoRepository.findByName(this.encarregadoName);
		
		if(encarregadoExists.isPresent()) {
			
			Encarregado encarregado = encarregadoRepository.getByName(this.encarregadoName);
			
			paiol.setSeal(this.seal);
			paiol.setLastEncarregoToOpen(encarregado);
			
			return paiol;
		}

		throw new RuntimeException("Encarregado não existe");
	}
	
}
