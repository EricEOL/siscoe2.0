package br.com.siscoe.siscoe.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Paiol;
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
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Paiol> update(@PathVariable Long id, @RequestBody UpdatePaiol updatePaiol) {
		
		Optional<Paiol> paiol = paiolRepository.findById(id);
		
		if(paiol.isPresent()) {
			Paiol paiolUpdated = updatePaiol.transform(id, paiolRepository, encarregadoRepository);
			return ResponseEntity.ok(paiolUpdated);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
