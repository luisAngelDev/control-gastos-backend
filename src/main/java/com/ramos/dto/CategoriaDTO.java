package com.ramos.dto;

import org.springframework.lang.NonNull;

public class CategoriaDTO {

	private Integer idCategoria;
	
	@NonNull
	private String nombre;
	
	@NonNull
	private String descripcion;
	
	
	/**
	 * GETTERS AND SETTERS
	 * @return
	 */

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
