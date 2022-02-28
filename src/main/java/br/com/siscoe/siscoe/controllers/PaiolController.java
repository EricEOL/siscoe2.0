package br.com.siscoe.siscoe.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Building;
import br.com.siscoe.siscoe.entities.dto.BuildingDTO;
import br.com.siscoe.siscoe.entities.form.paiol.FormUpdateSealAndLastEncarregadoToOpen;
import br.com.siscoe.siscoe.repositories.BuildingRepository;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;

@RestController
@RequestMapping("paiol")
public class PaiolController {

	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	EncarregadoRepository encarregadoRepository;
	
	@PutMapping("/updateseal/{id}")
	@Transactional
	public ResponseEntity<BuildingDTO> updateSealAndlastEncarregoToOpen(@PathVariable Long id, @RequestBody FormUpdateSealAndLastEncarregadoToOpen form) {
		
		Optional<Building> paiolExists = buildingRepository.findById(id);
		
		if(paiolExists.isPresent()) {
			Building paiol = form.transform(id, buildingRepository, encarregadoRepository);
			return ResponseEntity.ok(new BuildingDTO(paiol));
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
