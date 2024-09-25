package com.ramos.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.ramos.model.Categoria;
import com.ramos.model.Metodopago;

public class EgresoDTO { //plantillas para enviar y recibir datos
	
	private Integer idEgreso;
	
	@NotNull
	private String descripcion;
	
	@NotNull
	private Double monto;
	
	@NotNull
	private LocalDateTime fecha;
	
	@NotNull
	private Categoria categoria;
	
	@NotNull
	private Metodopago metodopago;
	

	/**
	 * GETTERS AND SETTERS
	 * @return
	 */
	
	public Integer getIdEgreso() {
		return idEgreso;
	}

	public void setIdEgreso(Integer idEgreso) {
		this.idEgreso = idEgreso;
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
