package com.ramos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "egreso")
public class Egreso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEgreso;
	
	@Column(name = "descripcion", nullable = false, length = 70)
	private String descripcion;
	
	@Column(name = "monto", nullable = false)
	private Double monto;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria",  nullable = false, foreignKey = @ForeignKey(name = "FK_egreso_categoria"))
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_metodopago",  nullable = false, foreignKey = @ForeignKey(name = "FK_egreso_metodopago"))
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
