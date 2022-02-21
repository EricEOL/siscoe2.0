package br.com.siscoe.siscoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Paiol;
import br.com.siscoe.siscoe.entities.dto.PaiolForm;
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
	public void add(@RequestBody PaiolForm paiolForm) {
		paiolRepository.save(paiolForm.transform());
	}
	
}
