package br.com.siscoe.siscoe.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.form.encarregado.EncarregadoForm;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;

@RestController
@RequestMapping("/encarregado")
public class EncarregadoController {

	@Autowired
	EncarregadoRepository encarregadoRepository;
	
	@PostMapping
	@Transactional
	public void add(@RequestBody @Valid EncarregadoForm encarregadoForm) {
		encarregadoRepository.save(encarregadoForm.transform());
	}
	
}
