package com.ramos.dto;

import org.springframework.lang.NonNull;

public class MetodopagoDTO {

	private Integer idMetodopago;
	
	@NonNull
	private String nombre;
	
	@NonNull
	private String descripcion;
	
	/**
	 * GETTERS AND SETTERS
	 * @return
	 */


	public Integer getIdMetodopago() {
		return idMetodopago;
	}

	public void setIdMetodopago(Integer idMetodopago) {
		this.idMetodopago = idMetodopago;
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
