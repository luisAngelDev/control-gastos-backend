package com.ramos.dto;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import com.ramos.model.Categoria;
import com.ramos.model.Metodopago;

public class IngresoDTO {
	
	private Integer idIngreso;
	
	@NonNull
	private String descripcion;
	
	@NonNull
	private Double monto;
	
	@NonNull
	private LocalDateTime fecha;
	
	@NonNull
	private Categoria categoria;
	
	@NonNull
	private Metodopago metodopago;
	
	
	
	/**
	 * GETTERS AND SETTERS
	 * @return
	 */

	public Integer getIdIngreso() {
		return idIngreso;
	}
	public void setIdIngreso(Integer idIngreso) {
		this.idIngreso = idIngreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Metodopago getMetodopago() {
		return metodopago;
	}
	public void setMetodopago(Metodopago metodopago) {
		this.metodopago = metodopago;
	}
	


	
	
	
	

}
