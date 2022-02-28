package br.com.siscoe.siscoe.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscoe.siscoe.entities.Building;
import br.com.siscoe.siscoe.entities.Encarregado;
import br.com.siscoe.siscoe.entities.dto.BuildingDTO;
import br.com.siscoe.siscoe.entities.form.encarregado.EncarregadoForm;
import br.com.siscoe.siscoe.repositories.EncarregadoRepository;

@RestController
@RequestMapping("/encarregado")
public class EncarregadoController {

	@Autowired
	EncarregadoRepository encarregadoRepository;
	
	@GetMapping
	public Page<Encarregado> list(@RequestParam(required = false) String cia, 
			@PageableDefault(sort = "number", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {
		
		if(cia == null) {
			Page<Encarregado> encarregados = encarregadoRepository.findAll(pageable);
			return encarregados;
		} else {
			Page<Encarregado> encarregados = encarregadoRepository.findByCia(cia, pageable);
			return encarregados;
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Encarregado> add(@RequestBody @Valid EncarregadoForm encarregadoForm) {
		Encarregado encarregado = encarregadoRepository.save(encarregadoForm.transform());
		return ResponseEntity.created(null).body(encarregado);
	}
	
}
