package com.ramos.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ramos.dto.MetodopagoDTO;
import com.ramos.exception.ModeloNotFoundException;
import com.ramos.model.Metodopago;
import com.ramos.service.IMetodopagoService;

@RestController
@RequestMapping("/metodopagos")
public class MetodopagoController {
	
	@Autowired
	private IMetodopagoService service;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<MetodopagoDTO>> listar() throws Exception {
		List<MetodopagoDTO> lista = service.listar().stream().map(p -> mapper.map(p, MetodopagoDTO.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MetodopagoDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Metodopago obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
						
		MetodopagoDTO dto = mapper.map(obj, MetodopagoDTO.class);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody MetodopagoDTO dto) throws Exception {
		Metodopago p = mapper.map(dto, Metodopago.class);
		Metodopago obj = service.registrar(p);
		
		//localhost:8080/pacientes/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMetodopago()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<MetodopagoDTO> modificar(@Valid @RequestBody MetodopagoDTO dto) throws Exception {
		Metodopago obj = service.listarPorId(dto.getIdMetodopago());
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdMetodopago());
		}
		
		Metodopago p = mapper.map(dto, Metodopago.class);		
		Metodopago pac = service.modificar(p);
		MetodopagoDTO dtoResponse = mapper.map(pac, MetodopagoDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Metodopago obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
