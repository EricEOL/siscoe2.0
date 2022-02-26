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

import br.com.siscoe.siscoe.entities.Paiol;
import br.com.siscoe.siscoe.entities.dto.PaiolDTO;
import br.com.siscoe.siscoe.entities.form.paiol.PaiolForm;
import br.com.siscoe.siscoe.entities.form.paiol.UpdatePaiol;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;
import br.com.siscoe.siscoe.repositories.PaiolRepository;

@RestController
@RequestMapping("/paiol")
public class PaiolController {
	
	@Autowired
	PaiolRepository paiolRepository;
	
	@Autowired
	EncarregadoRepository encarregadoRepository;
		
	@GetMapping
	public Page<PaiolDTO> list(@RequestParam(required = false) String cia, 
			@PageableDefault(sort = "number", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {
		
		if(cia == null) {
			Page<Paiol> paiois = paiolRepository.findAll(pageable);
			
			return PaiolDTO.transform(paiois);
		} else {
			
			Page<Paiol> paiois = paiolRepository.findByCia(cia, pageable);
			return PaiolDTO.transform(paiois);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaiolDTO> paiolById(@PathVariable Long id) {
		
		Boolean checkPaiolExists = paiolRepository.existsById(id);
		
		if(checkPaiolExists) {
			Paiol paiol = paiolRepository.getById(id);
			return ResponseEntity.ok(new PaiolDTO(paiol));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Paiol> add(@RequestBody @Valid PaiolForm paiolForm) {
		Paiol paiol = paiolForm.transform();
		paiolRepository.save(paiol);
		
		return ResponseEntity.created(null).body(paiol);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PaiolDTO> update(@PathVariable Long id, @RequestBody UpdatePaiol updatePaiol) {
		
		Optional<Paiol> paiol = paiolRepository.findById(id);
		
		if(paiol.isPresent()) {
			Paiol paiolUpdated = updatePaiol.transform(id, paiolRepository, encarregadoRepository);
			return ResponseEntity.ok(new PaiolDTO(paiolUpdated));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Paiol> delete(@PathVariable Long id) {
		
		Optional<Paiol> checkPaiolExists = paiolRepository.findById(id);
		
		if(checkPaiolExists.isPresent()) {
			paiolRepository.deleteById(id);
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.notFound().build();
	}
}
