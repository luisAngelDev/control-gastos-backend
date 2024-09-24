package com.ramos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metodopago")
public class Metodopago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMetodopago;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false, length = 70)
	private String descripcion;

	public Integer getIdMetodopago() {
		return idMetodopago;
	}
	
	/**
	 * GETTERS AND SETTERS
	 */

	

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
