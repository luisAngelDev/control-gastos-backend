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

import com.ramos.dto.CategoriaDTO;
import com.ramos.dto.IngresoDTO;
import com.ramos.exception.ModeloNotFoundException;
import com.ramos.model.Ingreso;
import com.ramos.service.IIngresoService;

@RestController
@RequestMapping("/ingresos")
public class IngresoController {
	
	@Autowired
	private IIngresoService service;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<IngresoDTO>> listar() throws Exception {
		List<IngresoDTO> lista = service.listar().stream().map(p -> mapper.map(p, IngresoDTO.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<IngresoDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Ingreso obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
						
		IngresoDTO dto = mapper.map(obj, IngresoDTO.class);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody IngresoDTO dto) throws Exception {
		Ingreso p = mapper.map(dto, Ingreso.class);
		Ingreso obj = service.registrar(p);
		
		//localhost:8080/pacientes/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdIngreso()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<IngresoDTO> modificar(@Valid @RequestBody IngresoDTO dto) throws Exception {
		Ingreso obj = service.listarPorId(dto.getIdIngreso());
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdIngreso());
		}
		
		Ingreso p = mapper.map(dto, Ingreso.class);		
		Ingreso pac = service.modificar(p);
		IngresoDTO dtoResponse = mapper.map(pac, IngresoDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Ingreso obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
