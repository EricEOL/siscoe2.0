package br.com.siscoe.siscoe.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Encarregado;
import br.com.siscoe.siscoe.entities.form.encarregado.EncarregadoForm;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;

@RestController
@RequestMapping("/encarregado")
public class EncarregadoController {

	@Autowired
	EncarregadoRepository encarregadoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Encarregado> add(@RequestBody @Valid EncarregadoForm encarregadoForm) {
		Encarregado encarregado = encarregadoRepository.save(encarregadoForm.transform());
		return ResponseEntity.created(null).body(encarregado);
	}
	
}
