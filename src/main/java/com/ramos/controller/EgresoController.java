package com.ramos.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import javax.sql.rowset.FilteredRowSet;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ramos.dto.EgresoDTO;
import com.ramos.dto.EgresoResumenDTO;
import com.ramos.dto.FiltroConsultaXmesDTO;
import com.ramos.exception.ModeloNotFoundException;
import com.ramos.model.Egreso;
import com.ramos.service.IEgresoService;

@RestController
@RequestMapping("/egresos")
public class EgresoController {
	
	@Autowired
	private IEgresoService service;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<EgresoDTO>> listar() throws Exception {
		List<EgresoDTO> lista = service.listar().stream().map(p -> mapper.map(p, EgresoDTO.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EgresoDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Egreso obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
						
		EgresoDTO dto = mapper.map(obj, EgresoDTO.class);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody EgresoDTO dto) throws Exception {
		Egreso p = mapper.map(dto, Egreso.class);
		Egreso obj = service.registrar(p);
		
		//localhost:8080/pacientes/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEgreso()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<EgresoDTO> modificar(@Valid @RequestBody EgresoDTO dto) throws Exception {
		Egreso obj = service.listarPorId(dto.getIdEgreso());
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdEgreso());
		}
		
		Egreso p = mapper.map(dto, Egreso.class);		
		Egreso pac = service.modificar(p);
		EgresoDTO dtoResponse = mapper.map(pac, EgresoDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Egreso obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//ADICIONALES AL CRUD
	
	@GetMapping("/listarResumenDia")
	public ResponseEntity<List<EgresoResumenDTO>> listarResumenDia() {
		List<EgresoResumenDTO> egresos = new ArrayList<>();
		
		egresos = service.listarResumenDia();
		
		return new ResponseEntity<>(egresos, HttpStatus.OK);
	}
	
	@GetMapping("/listarResumenxMes")
	public ResponseEntity<List<EgresoResumenDTO>> listarResumenXMes(@RequestParam(value = "mes") String mes, @RequestParam(value = "anio") String anio) {
		List<EgresoResumenDTO> egresos = new ArrayList<>();
		
		//egresos = service.listarResumenXMes(Integer.parseInt(filtro.getMes()), Integer.parseInt(filtro.getAnio()));
		//@RequestParam(value = "mes") String mes, @RequestParam(value = "anio") String anio
		egresos = service.listarResumenXMes(Integer.parseInt(mes), Integer.parseInt(anio));
		
		return new ResponseEntity<>(egresos, HttpStatus.OK);
	}           
	
	@GetMapping("/listartotalesMes")
	public ResponseEntity<List<EgresoResumenDTO>> listarTotalesMes(@RequestParam(value = "anio") String anio) {
		List<EgresoResumenDTO> egresos = new ArrayList<>();
		
		egresos = service.listarTotalesMes(Integer.parseInt(anio));
		
		return new ResponseEntity<>(egresos, HttpStatus.OK);
	}
	
	
	
}
