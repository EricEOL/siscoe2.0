package br.com.siscoe.siscoe.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Paiol;
import br.com.siscoe.siscoe.entities.form.paiol.PaiolForm;
import br.com.siscoe.siscoe.entities.form.paiol.UpdatePaiol;
import br.com.siscoe.siscoe.repositories.PaiolRepository;

@RestController
@RequestMapping("/paiol")
public class PaiolController {
	
	@Autowired
	PaiolRepository paiolRepository;
	
	@GetMapping
	public List<Paiol> all() {
		return paiolRepository.findAll(); 
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Paiol> add(@RequestBody @Valid PaiolForm paiolForm) {
		Paiol paiol = paiolForm.transform();
		paiolRepository.save(paiol);
		
		return ResponseEntity.created(null).body(paiol);
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody Long id, @RequestBody UpdatePaiol updatePaiol) {
		
		Optional<Paiol> paiol = paiolRepository.findById(id);
		
		if(paiol.isPresent()) {
			updatePaiol.transform(id, paiolRepository);
		}
		
	}
	
}
