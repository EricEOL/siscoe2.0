package br.com.siscoe.siscoe.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Building;
import br.com.siscoe.siscoe.entities.dto.BuildingDTO;
import br.com.siscoe.siscoe.entities.form.building.BuildingForm;
import br.com.siscoe.siscoe.entities.form.building.UpdateBuilding;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;
import br.com.siscoe.siscoe.repositories.BuildingRepository;

@RestController
@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	EncarregadoRepository encarregadoRepository;
		
	@GetMapping
	public Page<BuildingDTO> list(@RequestParam(required = false) String cia, 
			@PageableDefault(sort = "number", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {
		
		if(cia == null) {
			Page<Building> paiois = buildingRepository.findAll(pageable);
			
			return BuildingDTO.transform(paiois);
		} else {
			
			Page<Building> paiois = buildingRepository.findByCia(cia, pageable);
			return BuildingDTO.transform(paiois);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BuildingDTO> buildingById(@PathVariable Long id) {
		
		Boolean checkbuildingExists = buildingRepository.existsById(id);
		
		if(checkbuildingExists) {
			Building building = buildingRepository.getById(id);
			return ResponseEntity.ok(new BuildingDTO(building));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Building> add(@RequestBody @Valid BuildingForm buildingForm) {
		Building building = buildingForm.transform();
		buildingRepository.save(building);
		
		return ResponseEntity.created(null).body(building);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BuildingDTO> update(@PathVariable Long id, @RequestBody UpdateBuilding updateBuilding) {
		
		Optional<Building> building = buildingRepository.findById(id);
		
		if(building.isPresent()) {
			Building buildingUpdated = updateBuilding.transform(id, buildingRepository, encarregadoRepository);
			return ResponseEntity.ok(new BuildingDTO(buildingUpdated));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Building> delete(@PathVariable Long id) {
		
		Optional<Building> checkBuildingExists = buildingRepository.findById(id);
		
		if(checkBuildingExists.isPresent()) {
			buildingRepository.deleteById(id);
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.notFound().build();
	}
}
