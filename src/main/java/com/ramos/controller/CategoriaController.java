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
import com.ramos.exception.ModeloNotFoundException;
import com.ramos.model.Categoria;
import com.ramos.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService service;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listar() throws Exception {
		List<CategoriaDTO> lista = service.listar().stream().map(p -> mapper.map(p, CategoriaDTO.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Categoria obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
						
		CategoriaDTO dto = mapper.map(obj, CategoriaDTO.class);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody CategoriaDTO dto) throws Exception {
		Categoria p = mapper.map(dto, Categoria.class);
		Categoria obj = service.registrar(p);
		
		//localhost:8080/pacientes/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategoria()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<CategoriaDTO> modificar(@Valid @RequestBody CategoriaDTO dto) throws Exception {
		Categoria obj = service.listarPorId(dto.getIdCategoria());
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdCategoria());
		}
		
		Categoria p = mapper.map(dto, Categoria.class);		
		Categoria pac = service.modificar(p);
		CategoriaDTO dtoResponse = mapper.map(pac, CategoriaDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Categoria obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
